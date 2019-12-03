package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IManagementDAO;
import Model.EntityManagement;

import Exception.LocalException;
import Exception.AppartmentException;


public class ManagementDAO extends DAO<EntityManagement> implements IManagementDAO {
    @Override
    public EntityManagement insert(EntityManagement obj) {
        return null;
    }

    @Override
    public void delete(EntityManagement entityManagement) throws AppartmentException, LocalException {

    }

    public void update(EntityManagement obj) {

    }

    @Override
    public <L> EntityManagement getByPrimaryKey(L id) {
        return null;
    }
}
