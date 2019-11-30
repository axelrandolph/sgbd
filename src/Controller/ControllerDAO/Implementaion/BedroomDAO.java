package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Model.EntityBedroom;

public class BedroomDAO extends DAO<EntityBedroom> implements IBedroomDAO {
    @Override
    public EntityBedroom insert(EntityBedroom obj) {
        return null;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityBedroom obj) {
        return false;
    }

    @Override
    public EntityBedroom getById(int id) {
        return null;
    }
}
