package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Model.EntityAppartment;
import Model.EntityUser;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public EntityAppartment insert(EntityAppartment entityAppartment) throws SQLException {

        String sql = "INSERT INTO appartment(description, adress, state) VALUES(?, ?, ?);";
        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
        pst.setString(1, entityAppartment.getDescription());
        pst.setString(2, entityAppartment.getAdress());
        pst.setBoolean(3, entityAppartment.getState());
        pst.executeUpdate();
        ResultSet resultSet = pst.getGeneratedKeys();
        pst.close();

        entityAppartment.setIdAppartment(resultSet.getInt("idAppartment"));

        return entityAppartment;
    }

    @Override
    public void delete(int idAppartment) {

        String query = "delete from appartment where idAppartment= ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idAppartment);
            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(EntityAppartment obj) {

    }

    @Override
    public <L> EntityAppartment getByPrimaryKey(L id) throws SQLException {

        EntityAppartment appartment = new EntityAppartment();


        String sql = "SELECT * FROM appartment WHERE idAppartment = ?;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setInt(1, (Integer) id);
        ResultSet result = pst.executeQuery();
        if(result.first())
            appartment = new EntityAppartment(
                    result.getInt("idAppartment"),
                    result.getString("description"),
                    result.getString("adress"),
                    result.getBoolean("state")

            );

        return appartment;
    }


    @Override
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws SQLException {


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
            pst.setInt(indexParam , nbKitchen);
        }
        if (nbWaterPointByBathroom > 0) {
            ++indexParam;
            pst.setInt(indexParam , nbWaterPointByBathroom);
        }
        if (bedroomType != null) {
            ++indexParam;
            pst.setString(indexParam , bedroomType);
        }
        if (nbGasPointByKitchen > 0) {
            ++indexParam;
            pst.setInt(indexParam , nbGasPointByKitchen);
        }


        ResultSet resultSet = pst.executeQuery();
        ArrayList<EntityAppartment> entityAppartments = new ArrayList<EntityAppartment>();

        while (resultSet.next()) {
            EntityAppartment entityAppartment = new EntityAppartment(resultSet.getInt("idAppartment"),
                    resultSet.getString("adress"),
                    resultSet.getString("descriptionAppartment"),

                    resultSet.getBoolean("state"));

            entityAppartments.add(entityAppartment);
        }

        return entityAppartments;


    }

    private ArrayList<EntityAppartment> DisplayAppartmentByResulSet(ResultSet resultSet) throws SQLException {

        ArrayList<EntityAppartment> entityAppartments = new ArrayList<EntityAppartment>();

        while (resultSet.next()) {
            EntityAppartment entityAppartment = new EntityAppartment(resultSet.getInt("idAppartment"),
                    resultSet.getString("adress"),
                    resultSet.getString("descriptionAppartment"),

                    resultSet.getBoolean("state"));

            entityAppartments.add(entityAppartment);
        }

        return entityAppartments;
    }
    @Override
        public ArrayList<EntityAppartment> DisplayAppartmentResulSet() throws SQLException {
            String  sql ="SELECT * " +
                "FROM appartment" +
                    " WHERE idAppartment = idAppartment; " ;

        PreparedStatement pst = conn.prepareStatement(sql);

        ResultSet resultSet = pst.executeQuery();

        return DisplayAppartmentByResulSet(resultSet);
        }
    }



