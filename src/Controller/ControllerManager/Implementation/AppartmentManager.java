package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.EntityAppartment;
import Exception.*;
import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;

    public AppartmentManager() throws AppartmentException {

        if(UserManager.getCurrentUser() != null) {
            this.appartmentDAO = new AppartmentDAO();
        }

        else throw new AppartmentException("Veuillez connecter un utilisateur : ");
    }

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse) throws AppartmentException {

        EntityAppartment entityAppartment = new EntityAppartment(description, adresse, false);
        try {
            entityAppartment = appartmentDAO.insert(entityAppartment);
        } catch (LocalException | ConnectionException | UserException | ManagementException e) {
            throw new AppartmentException("Création de l'apparmtement impossible : " + e.getMessage());
        }

        return entityAppartment;
    }

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse, boolean state) throws AppartmentException{
        EntityAppartment entityAppartment = new EntityAppartment(description, adresse, state);
        try {
            entityAppartment = appartmentDAO.insert(entityAppartment);
        } catch (LocalException | ConnectionException | UserException | ManagementException e) {
            throw new AppartmentException("Création de l'apparmtement impossible : " + e.getMessage());
        }

        return entityAppartment;
    }

    @Override
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom,
                                                                        int nbKitchen, int nbWaterPointByBathroom,
                                                                        int nbGasPointByKitchen, String bedroomType) throws AppartmentException {

            return appartmentDAO.SearchAppartmentByCaracteristics(nbBathroom, nbBedroom, nbKitchen, nbWaterPointByBathroom, nbGasPointByKitchen, bedroomType);

    }

    @Override
    public ArrayList<EntityAppartment> getAllAppartment() throws AppartmentException {
        return SearchAppartmentByCaracteristics(-1,-1,-1,-1,-1,null);
    }


    @Override
    public void DeleteAppartment(int idAppartment) throws AppartmentException{

        try {
            appartmentDAO.delete(appartmentDAO.getByPrimaryKey(idAppartment));
        } catch (LocalException | ConnectionException | UserException | ManagementException e) {
            throw new AppartmentException("Votre appart n'est pas suuprimé");
        }

    }

}
