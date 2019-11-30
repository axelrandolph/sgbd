package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Controller.ControllerManager.Interfaces.IKitchenManager;
import Model.EntityAppartment;
import Model.EntityKitchen;

import java.sql.SQLException;

public class KitchenManager extends LocalManager implements IKitchenManager {

    private IKitchenDAO kitchenDAO;

    @Override
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws SQLException {

        EntityKitchen entityKitchen = new EntityKitchen(entityAppartment, description, area, nbgaspoint);
       return kitchenDAO.insert(entityKitchen);
    }
}
