package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerException.UserException;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Controller.ControllerManager.Interfaces.IBathroomManager;
import Controller.ControllerManager.Interfaces.ILocalManager;
import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;
    private ILocalManager localManager;
    public AppartmentManager() throws UserException {

        if(UserManager.getCurrentUser() != null) {
            this.appartmentDAO = new AppartmentDAO();
            this.localManager = new LocalManager();
        }

        else throw new UserException();
    }

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse) throws SQLException {

        EntityAppartment entityAppartment = new EntityAppartment(description,adresse, false);
        entityAppartment = appartmentDAO.insert(entityAppartment);

        return entityAppartment;
    }

    @Override
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws SQLException {

        String appartmentView = "AppartmentView";
        appartmentDAO.CreateOrReplaceAppartmentView(appartmentView);
        localManager.AppartmentViewByCaracteristics(nbBathroom,nbBedroom,nbKitchen,nbWaterPointByBathroom,nbGasPointByKitchen,bedroomType, appartmentView);
        return appartmentDAO.DisplayAppartmentView(appartmentView);

    }



    @Override
    public void DeleteAppartment(int idAppartment){

        appartmentDAO.delete(idAppartment);
    }

}
