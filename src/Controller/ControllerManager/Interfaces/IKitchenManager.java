package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityKitchen;

import java.sql.SQLException;

public interface IKitchenManager {

    /**
     * @param entityAppartment
     * @param description
     * @param area
     * @param nbgaspoint
     * @return
     */
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws SQLException;


}
