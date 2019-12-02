package Controller.ControllerDAO.Interfaces;

import Model.EntityAppartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IAppartmentDAO extends IDAO<EntityAppartment> {
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws SQLException;

    ArrayList<EntityAppartment> DisplayAppartmentResulSet() throws SQLException;
}
