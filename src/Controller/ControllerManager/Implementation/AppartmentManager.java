package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals) {

        EntityAppartment entityAppartment = new EntityAppartment(description,adresse, false);
        entityAppartment = appartmentDAO.insert(entityAppartment);


        return entityAppartment;
    }
}
