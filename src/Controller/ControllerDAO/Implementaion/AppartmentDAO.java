package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Model.EntityAppartment;

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
        return null;
    }
}
