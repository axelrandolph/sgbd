package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBathroom;

import java.sql.SQLException;
import java.util.ArrayList;
import Exception.LocalException;

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
    public EntityBathroom CreateBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) throws LocalException;

}
