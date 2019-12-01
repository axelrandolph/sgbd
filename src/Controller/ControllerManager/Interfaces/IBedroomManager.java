package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBedroom;

import java.sql.SQLException;

public interface IBedroomManager {


    public EntityBedroom CreateBedroom(EntityAppartment entityAppartment, String description, float area, String typeBedroom) throws SQLException;

    void DeleteBedroom(int idAppartment, int idLocal);
}
