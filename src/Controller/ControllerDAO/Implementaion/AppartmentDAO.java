package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Model.EntityAppartment;
import Model.EntityUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AppartmentDAO extends DAO<EntityAppartment> implements IAppartmentDAO {
    @Override
    public boolean insert(EntityAppartment obj) {
        return false;
    }

    @Override
    public boolean delete(EntityAppartment obj) {
        return false;
    }

    @Override
    public boolean update(EntityAppartment obj) {
        return false;
    }

    @Override
    public EntityAppartment find(int id) {

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


