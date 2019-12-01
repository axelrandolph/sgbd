package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Model.EntityConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDAO extends DAO<EntityConnection> implements IConnectionDAO {
    @Override
    public EntityConnection insert(EntityConnection obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityConnection obj) {
        return false;
    }

    @Override
    public <L> EntityConnection getByPrimaryKey(L id) {
        return null;
    }

    @Override
    public void AddLocalToConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws SQLException {
        String sql = "INSERT INTO connectedlocal(idConnectedLocal, LocalType, idAppartment) VALUES(?, ?, ?);";
        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setInt(1, idLocal);
        pst.setString(2, typeLocal);
        pst.setInt(3, idAppartment);
        pst.executeUpdate();
        pst.close();

    }
}
