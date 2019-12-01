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
    public boolean delete(int idAppartment) {

        String query = "delete from appartment where idAppartment= ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idAppartment);
            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(EntityAppartment obj) {
        return false;
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
    public void CreateOrReplaceAppartmentView(String appartmentView) throws SQLException {

        String sql = "CREATE OR REPLACE VIEW ? " +
                "AS SELECT * " +
                "FROM appartment " +
                "FULL JOIN bathroom ON appartment.idAppartment = bathroom.idAppartment" +
                "FULL JOIN bedroom on appartment.idAppartment = bedroom.idAppartment" +
                "FULL JOIN kitchen on appartment.idAppartment = kitchen.idAppartment;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, appartmentView);
        pst.execute();
    }

    @Override
    public ArrayList<EntityAppartment> DisplayAppartmentView(String appartmentView) throws SQLException {

        ArrayList<EntityAppartment> entityAppartments = new ArrayList<EntityAppartment>();

        String sql = "SELECT appartment.idAppartment, appartment.description, appartment.adress, appartment.state" +
                "FROM ?";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, appartmentView);
        ResultSet resultSet = pst.executeQuery();
        while(resultSet.next()){
            EntityAppartment entityAppartment = new EntityAppartment(resultSet.getInt("appartment.idAppartement"),
                    resultSet.getString("appartment.description"),
                    resultSet.getString("appartment.adress"),
                    resultSet.getBoolean("appartment.state"));

            entityAppartments.add(entityAppartment);
        }

        return entityAppartments;
    }
}


