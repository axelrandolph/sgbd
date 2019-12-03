package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerException.UserException;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;
    public AppartmentManager() throws UserException {

        if(UserManager.getCurrentUser() != null) {
            this.appartmentDAO = new AppartmentDAO();
        }

       else throw new UserException();
    }

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse,boolean state) throws SQLException {

        EntityAppartment entityAppartment = new EntityAppartment(description,adresse,state);
        try {
            entityAppartment = appartmentDAO.insert(entityAppartment);
        } catch (Exception.AppartmentException e) {
            e.printStackTrace();

        } catch (Exception.LocalException e) {
            e.printStackTrace();
        } catch (Exception.ConnectionException e) {
            e.printStackTrace();
        }

        return entityAppartment;
    }

    @Override
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws SQLException {

        return appartmentDAO.SearchAppartmentByCaracteristics(nbBathroom,nbBedroom,nbKitchen,nbWaterPointByBathroom,nbGasPointByKitchen,bedroomType);

    }



    @Override
    public void DeleteAppartment(int idAppartment){

        appartmentDAO.delete(idAppartment);
    }

}
