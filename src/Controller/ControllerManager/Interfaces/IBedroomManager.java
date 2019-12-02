package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityBedroom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBedroomManager {


    public EntityBedroom CreateBedroom(EntityAppartment entityAppartment, String description, float area, String typeBedroom) throws SQLException;

    void DeleteBedroom(int idAppartment, int idLocal);

    public void AppartmentViewByCaracteristics(int nbBedroom, String bedroomType, String appartmentView) throws SQLException;
}
