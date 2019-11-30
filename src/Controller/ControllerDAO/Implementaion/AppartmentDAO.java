package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Model.EntityAppartment;
import Model.EntityUser;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        entityAppartment.setIdAppartment(resultSet.getInt(1));

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
    public EntityAppartment getById(int id) {

        EntityAppartment appartment = new EntityAppartment();

        try {
            ResultSet result = this.getConn().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM appartment WHERE idAppartment = " + id);
            if(result.first())
                appartment = new EntityAppartment(
                        result.getInt("idAppartment"),
                        result.getString("description"),
                        result.getString("adress"),
                        result.getBoolean("state")

                );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appartment;
    }

}


