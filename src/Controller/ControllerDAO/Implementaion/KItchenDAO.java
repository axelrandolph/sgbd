package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.EntityKitchen;

public class KItchenDAO extends DAO<EntityKitchen> implements IKitchenDAO {
    @Override
    public EntityKitchen insert(EntityKitchen obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityKitchen obj) {
        return false;
    }

    @Override
    public EntityKitchen getById(int id) {
        return null;
    }
}
