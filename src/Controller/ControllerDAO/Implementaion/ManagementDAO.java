package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IManagementDAO;
import Model.EntityManagement;
<<<<<<< HEAD
import Exception.LocalException;
import Exception.AppartmentException;
=======
import Exception.*;
>>>>>>> f17f947837fb38939b260831cc87412132f9d602

public class ManagementDAO extends DAO<EntityManagement> implements IManagementDAO {
    @Override
    public EntityManagement insert(EntityManagement obj) {
        return null;
    }

    @Override
<<<<<<< HEAD
    public void delete(EntityManagement entityManagement) throws AppartmentException, LocalException {
=======
    public void delete(EntityManagement obj) throws AppartmentException, LocalException {

    }

    @Override
    public void delete(int obj){
    }

    @Override
    public void update(EntityManagement obj) {
>>>>>>> f17f947837fb38939b260831cc87412132f9d602

    }

    @Override
    public <L> EntityManagement getByPrimaryKey(L id) {
        return null;
    }
}
