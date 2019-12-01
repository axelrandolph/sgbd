package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.KItchenDAO;
import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Controller.ControllerException.UserException;
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
        else throw new UserException();
    }

    @Override
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws SQLException {

        EntityKitchen entityKitchen = new EntityKitchen(entityAppartment, description, area, nbgaspoint);
       return kitchenDAO.insert(entityKitchen);
    }

    @Override
    public void DeleteKitchen(int idAppartment, int idLocal) {

    }

    @Override
    public void AppartmentViewByCaracteristics(int nbKitchen, int nbGasPointByKitchen, String appartmentView) throws SQLException {
        kitchenDAO.AppartmentViewByCaracteristics(nbKitchen,nbGasPointByKitchen, appartmentView);
    }
}
