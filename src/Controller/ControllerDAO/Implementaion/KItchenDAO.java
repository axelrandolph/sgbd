package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.EntityKitchen;

public class KItchenDAO extends DAO<EntityKitchen> implements IKitchenDAO {
    @Override
    public boolean insert(EntityKitchen obj) {
        return false;
    }

    @Override
    public boolean delete(EntityKitchen obj) {
        return false;
    }

    @Override
    public boolean update(EntityKitchen obj) {
        return false;
    }

    @Override
    public EntityKitchen find(int id) {
        return null;
    }
}
