package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IManagementDAO;
import Model.EntityManagement;

public class ManagementDAO extends DAO<EntityManagement> implements IManagementDAO {
    @Override
    public EntityManagement insert(EntityManagement obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityManagement obj) {
        return false;
    }

    @Override
    public EntityManagement getById(int id) {
        return null;
    }
}
