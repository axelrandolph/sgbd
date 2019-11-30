package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Model.EntityConnection;

public class ConnectionDAO extends DAO<EntityConnection> implements IConnectionDAO {
    @Override
    public boolean insert(EntityConnection obj) {
        return false;
    }

    @Override
    public boolean delete(EntityConnection obj) {
        return false;
    }

    @Override
    public boolean update(EntityConnection obj) {
        return false;
    }

    @Override
    public EntityConnection find(int id) {
        return null;
    }
}
