package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;
import Exception.*;
public interface IAppartmentManager {

    EntityAppartment CreateAppartment(String description, String adresse) throws SQLException, LocalException, AppartmentException, ConnectionException, Exception;

    /**
     *
     * @param description
     * @param adresse
     * @return
     * @throws SQLException
     */
    //public EntityAppartment CreateAppartment(String description, String adresse) throws SQLException;

    public EntityAppartment CreateAppartment(String description, String adresse, boolean state) throws SQLException;

    /**
     *
     * @param nbBathroom
     * @param nbBedroom
     * @param nbKitchen
     * @param nbWaterPointByBathroom
     * @param nbGasPointByKitchen
     * @param bedroomType
     * @return
     * @throws SQLException
     */
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom,
                                                                        int nbBedroom,
                                                                        int nbKitchen,
                                                                        int nbWaterPointByBathroom,
                                                                        int nbGasPointByKitchen,
                                                                        String bedroomType) throws SQLException, AppartmentException, AppartmentException, Exception;

    /**
     *
     * @param idAppartment
     */
    void DeleteAppartment(int idAppartment) throws LocalException, AppartmentException, Exception;
}
