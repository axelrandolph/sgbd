package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Model.EntityBathroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BathroomDAO extends DAO<EntityBathroom> implements IBathroomDAO {
    @Override
    public EntityBathroom insert(EntityBathroom entityBathroom) {

        String sql = "INSERT INTO bathroom(description, area, nbWaterPoint) VALUES(?, ?, ?);";
        PreparedStatement pst = null;
        try {
            pst = getConn().prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, entityBathroom.getDescription());
            pst.setFloat(2, entityBathroom.getArea());
            pst.setInt(3, entityBathroom.getNbWaterPoint());

            pst.executeUpdate();
            ResultSet resultSet = pst.getGeneratedKeys();
            pst.close();

            entityBathroom.setIdLocal(resultSet.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return entityBathroom;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }


    public boolean deleteBY(int idAppartment, int idBathroom) {
        String query = "delete from appartment where idAppartment= ? AND idBathroom = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idAppartment);
            preparedStmt.setInt(2, idBathroom);

            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(EntityBathroom obj) {
        return false;
    }

    @Override
    public EntityBathroom getById(int id) {
        return null;
    }
}
