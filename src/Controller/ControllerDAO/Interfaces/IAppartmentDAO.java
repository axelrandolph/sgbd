package Controller.ControllerDAO.Interfaces;

import Model.EntityAppartment;

import Exception.AppartmentException;

import java.util.ArrayList;

public interface IAppartmentDAO extends IDAO<EntityAppartment> {
    /**
     * Cette methode permet de chercher un appartement en fonction de different criteres
     * @param nbBathroom
     * @param nbBedroom
     * @param nbKitchen
     * @param nbWaterPointByBathroom
     * @param nbGasPointByKitchen
     * @param bedroomType
     * @return
     * @throws AppartmentException
     */
    ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws AppartmentException;

    /**
     * Cette methode renvoie une liste d'appartment
      * @return <EntityAppartment> : list
     * @throws AppartmentException
     */
    ArrayList<EntityAppartment> get() throws AppartmentException;

    EntityAppartment updateAppartment (EntityAppartment appartment, String description, String adress, boolean state) throws AppartmentException;
}
