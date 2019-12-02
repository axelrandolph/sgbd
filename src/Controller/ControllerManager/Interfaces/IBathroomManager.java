package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBathroom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBathroomManager {

    /**
     *
     * @param entityAppartment
     * @param description
     * @param area
     * @param nbwaterpoint
     * @return
     * @throws SQLException
     */
    public EntityBathroom CreateBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) throws SQLException;

    /**
     *
     * @param idAppartment
     * @param idBathroom
     */
    public void DeleteBathroom(int idAppartment, int idBathroom);

    /**
     *
     * @param nbBathroom
     * @param nbWaterPointByBathroom
     * @param appartmentView
     * @throws SQLException
     */
    public void AppartmentViewByCaracteristics(int nbBathroom, int nbWaterPointByBathroom, String appartmentView) throws SQLException;

}
