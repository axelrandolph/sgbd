package Controller.ControllerManager.Interfaces;

import Model.EntityBathroom;

public interface IBathroomManager {

    public EntityBathroom CreateBathroom(int idAppartment, String description, float area, int nbwaterpoint);

}
