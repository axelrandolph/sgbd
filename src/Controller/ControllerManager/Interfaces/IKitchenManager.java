package Controller.ControllerManager.Interfaces;

import Model.EntityKitchen;

public interface IKitchenManager {

    /**
     * @param idAppartment
     * @param description
     * @param area
     * @param nbgaspoint
     * @return
     */
    public EntityKitchen CreateKitchen(int idAppartment, String description, float area, int nbgaspoint);


}
