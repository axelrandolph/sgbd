package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.EntityAppartment;
import Exception.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;
    public AppartmentManager() throws UserException {

        if(UserManager.getCurrentUser() != null) {
            this.appartmentDAO = new AppartmentDAO();
        }

        else throw new UserException("");
    }

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse) throws Exception {

        EntityAppartment entityAppartment = new EntityAppartment(description, adresse, false);
        entityAppartment = appartmentDAO.insert(entityAppartment);

        return entityAppartment;
    }

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse, boolean state) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<EntityAppartment> SearchAppartmentByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType) throws Exception {

        return appartmentDAO.SearchAppartmentByCaracteristics(nbBathroom, nbBedroom, nbKitchen, nbWaterPointByBathroom, nbGasPointByKitchen, bedroomType);

    }



    @Override
    public void DeleteAppartment(int idAppartment) throws AppartmentException{

        try {
            appartmentDAO.delete(appartmentDAO.getByPrimaryKey(idAppartment));
        } catch (LocalException | SQLException | ConnectionException e) {
            e.printStackTrace();
        }
    }

}
