package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IManagementDAO;
import Model.EntityManagement;

public class ManagementDAO extends DAO<EntityManagement> implements IManagementDAO {
    @Override
    public boolean insert(EntityManagement obj) {
        return false;
    }

    @Override
    public boolean delete(EntityManagement obj) {
        return false;
    }

    @Override
    public boolean update(EntityManagement obj) {
        return false;
    }

    @Override
    public EntityManagement find(int id) {
        return null;
    }
}
