package Controller.ControllerDAO.Interfaces;

import Model.EntityAppartment;

import Exception.AppartmentException;

import java.util.ArrayList;

public interface IAppartmentDAO extends IDAO<EntityAppartment> {
    ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws AppartmentException;


    EntityAppartment updateAppartment (EntityAppartment appartment, String description, String adress, boolean state) throws AppartmentException;
}
