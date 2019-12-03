package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;
import Exception.*;
public interface IAppartmentManager {

    EntityAppartment CreateAppartment(String description, String adresse) throws  AppartmentException;

    /**
     *
     * @param description
     * @param adresse
     * @return
     */
    EntityAppartment CreateAppartment(String description, String adresse, boolean state) throws AppartmentException;

    /**
     *
     * @param nbBathroom
     * @param nbBedroom
     * @param nbKitchen
     * @param nbWaterPointByBathroom
     * @param nbGasPointByKitchen
     * @param bedroomType
     * @return
     */
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom,
                                                                        int nbBedroom,
                                                                        int nbKitchen,
                                                                        int nbWaterPointByBathroom,
                                                                        int nbGasPointByKitchen,
                                                                        String bedroomType) throws AppartmentException, SQLException;

    /**
     *
     * @param idAppartment
     */
    void DeleteAppartment(int idAppartment) throws AppartmentException;
}
