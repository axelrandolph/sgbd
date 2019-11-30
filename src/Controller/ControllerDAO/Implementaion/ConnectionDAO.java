package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Model.EntityConnection;

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
    public EntityConnection getById(int id) {
        return null;
    }
}
