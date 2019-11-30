package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Controller.ControllerManager.Interfaces.IBedroomManager;
import Model.EntityAppartment;
import Model.EntityBedroom;

import java.sql.SQLException;

public class BedroomManager extends LocalManager implements IBedroomManager {

    private IBedroomDAO bedroomDAO;

    @Override
    public EntityBedroom CreateBedroom(EntityAppartment entityAppartment, String description, float area, String typeBedroom) throws SQLException {

        EntityBedroom entityBedroom = new EntityBedroom(entityAppartment, description, area, typeBedroom);
        return bedroomDAO.insert(entityBedroom);
    }
}
