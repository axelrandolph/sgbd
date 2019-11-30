package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals) throws SQLException {

        EntityAppartment entityAppartment = new EntityAppartment(description,adresse, false);
        entityAppartment = appartmentDAO.insert(entityAppartment);


        return entityAppartment;
    }

    public void displayAppartment( int idAppartment){

        appartmentDAO.find(idAppartment);
    }

}
