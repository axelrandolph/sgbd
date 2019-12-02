package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAppartmentManager {

    /**
     *
     * @param description
     * @param adresse
     * @return
     * @throws SQLException
     */
    public EntityAppartment CreateAppartment(String description, String adresse) throws SQLException;

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
                                                                        String bedroomType) throws SQLException;

    /**
     *
     * @param idAppartment
     */
    void DeleteAppartment(int idAppartment);
}
