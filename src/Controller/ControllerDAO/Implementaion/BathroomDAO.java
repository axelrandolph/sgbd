package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Model.EntityBathroom;

public class BathroomDAO extends DAO<EntityBathroom> implements IBathroomDAO {
    @Override
    public EntityBathroom insert(EntityBathroom obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean delete(EntityBathroom obj) {
        return false;
    }

    @Override
    public boolean update(EntityBathroom obj) {
        return false;
    }

    @Override
    public EntityBathroom find(int id) {
        return null;
    }
}
