package Controller.ControllerManager.Interfaces;

import Model.EntityBedroom;

public interface IBedroomManager {


    public EntityBedroom CreateBedroom(int idappartment, String description, float area, String typeBedroom);

}
