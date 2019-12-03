package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IManagementDAO;
import Model.EntityManagement;
import Exception.*;

public class ManagementDAO extends DAO<EntityManagement> implements IManagementDAO {
    @Override
    public EntityManagement insert(EntityManagement obj) {
        return null;
    }

    @Override
    public void delete(EntityManagement obj) throws AppartmentException, LocalException {

    }

    @Override
    public void delete(int obj){
    }

    @Override
    public void update(EntityManagement obj) {

    }

    @Override
    public <L> EntityManagement getByPrimaryKey(L id) {
        return null;
    }
}
