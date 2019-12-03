package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.KItchenDAO;
import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Exception.*;
import Controller.ControllerManager.Interfaces.IKitchenManager;
import Model.EntityAppartment;
import Model.EntityKitchen;

import java.sql.SQLException;

public class KitchenManager implements IKitchenManager {

    private IKitchenDAO kitchenDAO;

    public KitchenManager() throws UserException {
        if (UserManager.getCurrentUser() != null){
            this.kitchenDAO = new KItchenDAO();
        }
        else throw new UserException(" Votre cuisine n'existe pas");
    }

    @Override
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws SQLException, LocalException, ConnectionException, AppartmentException {

        EntityKitchen entityKitchen = new EntityKitchen(entityAppartment, description, area, nbgaspoint);
       return kitchenDAO.insert(entityKitchen);
    }

    @Override
    public void DeleteKitchen(int idAppartment, int idLocal) {

    }

}
