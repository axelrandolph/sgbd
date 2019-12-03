package Controller.ControllerDAO.Interfaces;

import Model.EntityAppartment;

import Exception.AppartmentException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAppartmentDAO extends IDAO<EntityAppartment> {
    ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws AppartmentException, SQLException;

    ArrayList<EntityAppartment> DisplayAppartmentResulSet() throws SQLException;
}
