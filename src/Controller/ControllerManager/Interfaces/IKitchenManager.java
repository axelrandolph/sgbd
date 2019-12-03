package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityKitchen;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IKitchenManager {

    /**
     * @param entityAppartment
     * @param description
     * @param area
     * @param nbgaspoint
     * @return
     */
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws SQLException, LocalException, AppartmentException, ConnectionException, Exception.LocalException, ConnectionException, AppartmentException;


    void DeleteKitchen(int idAppartment, int idLocal);

}
