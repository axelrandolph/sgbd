package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Model.EntityBedroom;

public class BedroomDAO extends DAO<EntityBedroom> implements IBedroomDAO {
    @Override
    public boolean insert(EntityBedroom obj) {
        return false;
    }

    @Override
    public boolean delete(EntityBedroom obj) {
        return false;
    }

    @Override
    public boolean update(EntityBedroom obj) {
        return false;
    }

    @Override
    public EntityBedroom find(int id) {
        return null;
    }
}
