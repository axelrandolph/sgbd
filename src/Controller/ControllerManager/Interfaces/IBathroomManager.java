package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBathroom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBathroomManager {

    public EntityBathroom CreateBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) throws SQLException;

    public void DeleteBathroom(int idAppartment, int idBathroom);

    public void AppartmentViewByCaracteristics(int nbBathroom, int nbWaterPointByBathroom, String appartmentView) throws SQLException;

}
