package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBedroom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBedroomManager {


    /**
     *
     * @param entityAppartment
     * @param description
     * @param area
     * @param typeBedroom
     * @return
     * @throws SQLException
     */
    public EntityBedroom CreateBedroom(EntityAppartment entityAppartment, String description, float area, String typeBedroom) throws SQLException;

    /**
     *
     * @param idAppartment
     * @param idLocal
     */
    void DeleteBedroom(int idAppartment, int idLocal);

}
