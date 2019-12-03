package Controller.ControllerManager.Interfaces;

import Model.EntityAppartment;
import Model.EntityKitchen;

import java.sql.SQLException;
import Exception.*;
import java.util.ArrayList;

public interface IKitchenManager {

    /**
     * @param entityAppartment
     * @param description
     * @param area
     * @param nbgaspoint
     * @return
     */
    EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws  LocalException;


    void DeleteKitchen(int idAppartment, int idLocal) throws LocalException;

}
