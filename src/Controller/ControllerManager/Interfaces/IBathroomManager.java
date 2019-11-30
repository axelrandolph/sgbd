package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBathroom;

import java.sql.SQLException;

public interface IBathroomManager {

    public EntityBathroom CreateBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) throws SQLException;

}
