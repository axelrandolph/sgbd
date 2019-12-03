package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Model.EntityAppartment;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.AppartmentException;

public class AppartmentDAO extends DAO<EntityAppartment> implements IAppartmentDAO {
    public AppartmentDAO() {
        super();
    }

    /**
     * register an appartment object
     *
     * @param entityAppartment
     * @return the appartment registred otherwise null
     */
    @Override
    public EntityAppartment insert(EntityAppartment entityAppartment) throws AppartmentException {

        try {
            String sql = "INSERT INTO appartment(description, adress, state) VALUES(?, ?, ?);";
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, entityAppartment.getDescription());
            pst.setString(2, entityAppartment.getAdress());
            pst.setBoolean(3, entityAppartment.getState());
            pst.executeUpdate();
            ResultSet resultSet = pst.getGeneratedKeys();

            entityAppartment.setIdAppartment(resultSet.getInt("idAppartment"));
            pst.close();

        }catch (SQLException e) {
            throw new AppartmentException("Echec lors de la l'insertion de l'appartement " + entityAppartment.getIdAppartment()+ "due à l'erreur suivante  : "  + e.getMessage());
        }
        return entityAppartment;
    }

    @Override
    public void delete(EntityAppartment entityAppartment) throws AppartmentException {

        int idAppartment = entityAppartment.getIdAppartment();
        String query = "delete from appartment where idAppartment= ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idAppartment);
            preparedStmt.execute();

            preparedStmt.close();

        } catch (SQLException e) {
            throw new AppartmentException("Echec lors de la délétion de l'appartement " + entityAppartment.getIdAppartment()+ "due à l'erreur suivante  : "  + e.getMessage());
        }
    }



    @Override
    public <L> EntityAppartment getByPrimaryKey(L id) throws AppartmentException {

        EntityAppartment appartment = new EntityAppartment();

        try {
            String sql = "SELECT * FROM appartment WHERE idAppartment = ?;";

            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, (Integer) id);
            ResultSet result = pst.executeQuery();
            if (result.first())
                appartment = new EntityAppartment(
                        result.getInt("idAppartment"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getBoolean("state")

                );
            pst.close();
            result.close();
        } catch (SQLException e){
            throw new AppartmentException("Impossible d'obtenir l'appartment numero : "+ id +"due à l'erreur suivante : " + e.getMessage());
        }

        return appartment;
    }


    @Override
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws AppartmentException {


        String sql ="SELECT * " +
                "FROM appartment " +
                "WHERE idAppartment = idAppartment ";


        String sqlnbBathroom = "AND idAppartment IN " +
                "(SELECT idAppartment " +
                "FROM bathroom " +
                "GROUP BY idAppartment " +
                "HAVING COUNT(*) = ?) ";

        String sqlnbBedroom = "AND idAppartment IN " +
                "(SELECT idAppartment " +
                "FROM bedroom " +
                "GROUP BY idAppartment " +
                "HAVING COUNT(*) = ?) ";

        String sqlnbKitchen = "AND idAppartment IN " +
                "(SELECT idAppartment " +
                "FROM kitchen " +
                "GROUP BY idAppartment " +
                "HAVING COUNT(*) = ?) ";

        String sqlnbWaterPoint = "AND idAppartment IN " +
                "(SELECT idAppartment " +
                "FROM bathroom " +
                "WHERE nbWaterPoint = ?) ";

        String sqlTypeBedroom = "AND idAppartment IN " +
                "(SELECT idAppartment " +
                "FROM bedroom " +
                "WHERE bedroomType = ?) ";

        String sqlnbGasPoint = "AND idAppartment IN " +
                "(SELECT idAppartment " +
                "FROM kitchen " +
                "WHERE nbGasPoint = ?) ";

        String sqlnbBathroomZero = "AND idAppartment NOT IN " +
                "(SELECT idAppartment " +
                "FROM bathroom) ";

        String sqlnbKitchenZero = "AND idAppartment NOT IN " +
                "(SELECT idAppartment " +
                "FROM kitchen) ";

        String sqlnbBedroomZero = "AND idAppartment NOT IN " +
                "(SELECT idAppartment " +
                "FROM bedroom) ";




        if (nbBathroom > 0) {
            sql = sql.concat(sqlnbBathroom);
        }
        if (nbBedroom > 0) {
            sql = sql.concat(sqlnbBedroom);
        }
        if (nbKitchen > 0) {
            sql = sql.concat(sqlnbKitchen);
        }
        if (nbWaterPointByBathroom > 0) {
            sql = sql.concat(sqlnbWaterPoint);
        }
        if (bedroomType != null) {
            sql = sql.concat(sqlTypeBedroom);
        }
        if (nbGasPointByKitchen > 0) {
            sql = sql.concat(sqlnbGasPoint);
        }

        if (nbBathroom == 0){
            sql = sql.concat(sqlnbBathroomZero);
        }
        if (nbBedroom == 0){
            sql = sql.concat(sqlnbBedroomZero);
        }
        if (nbKitchen == 0){
            sql = sql.concat(sqlnbKitchenZero);
        }

        sql = sql.concat(";");

        try {

            PreparedStatement pst = conn.prepareStatement(sql);

            int indexParam = 0;

            if (nbBathroom > 0) {
                ++indexParam;
                pst.setInt(indexParam, nbBathroom);
            }
            if (nbBedroom > 0) {
                ++indexParam;
                pst.setInt(indexParam, nbBedroom);
            }
            if (nbKitchen > 0) {
                ++indexParam;
                pst.setInt(indexParam, nbKitchen);
            }
            if (nbWaterPointByBathroom > 0) {
                ++indexParam;
                pst.setInt(indexParam, nbWaterPointByBathroom);
            }
            if (bedroomType != null) {
                ++indexParam;
                pst.setString(indexParam, bedroomType);
            }
            if (nbGasPointByKitchen > 0) {
                ++indexParam;
                pst.setInt(indexParam, nbGasPointByKitchen);
            }


            ResultSet resultSet = pst.executeQuery();
            pst.close();

            return DisplayAppartmentByResulSet(resultSet);

        }catch (SQLException | AppartmentException e) {
            throw new AppartmentException("Echec lors de la recherche de l'appartement  due à l'erreur suivante  : "  + e.getMessage());
        }


    }

    private ArrayList<EntityAppartment> DisplayAppartmentByResulSet(ResultSet resultSet) throws AppartmentException {

        ArrayList<EntityAppartment> entityAppartments = new ArrayList<EntityAppartment>();

        try {
            while (resultSet.next()) {
                EntityAppartment entityAppartment = new EntityAppartment(resultSet.getInt("idAppartment"),
                        resultSet.getString("adress"),
                        resultSet.getString("description"),

                        resultSet.getBoolean("state"));

                entityAppartments.add(entityAppartment);
            }
            resultSet.close();

        }catch (SQLException e ){
            throw new AppartmentException("la recheche à trouvé un appartement mais a fait une erreur lors de son affichage : " + e.getMessage());
        }
        return entityAppartments;
    }


    @Override
    public EntityAppartment updateAppartment(EntityAppartment appartment, String description, String adress, boolean state) throws AppartmentException {


        String sql = "UPDATE appartment " +
                "SET description = ?, " +
                "  adress = ?, " +
                "  state = ? " +
                "WHERE idAppartment = ?";

        try {
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, description);
            pst.setString(2,  adress);
            pst.setBoolean(3, state);
            pst.setInt(4,  appartment.getIdAppartment());

            pst.executeUpdate();

            pst.close();

        }catch (SQLException e){
            throw new AppartmentException("Impossible de mettre a jour l'appartment : " + appartment.getIdAppartment() + " due  à l'erreur suivante : "+ e.getMessage());
        }

        appartment.setAdress(adress);
        appartment.setState(state);
        appartment.setDescription(description);

        return appartment;
    }
}



