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
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws SQLException;


    void DeleteKitchen(int idAppartment, int idLocal);

    public void AppartmentViewByCaracteristics(int nbKitchen, int nbGasPointByKitchen, String appartmentView) throws SQLException;
}
