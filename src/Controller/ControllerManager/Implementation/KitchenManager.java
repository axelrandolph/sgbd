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

    public KitchenManager() throws LocalException {
        if (UserManager.getCurrentUser() != null){
            this.kitchenDAO = new KItchenDAO();
        }
        else throw new LocalException(" Votre cuisine n'existe pas");
    }

    @Override
    public EntityKitchen CreateKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) throws  LocalException {

        EntityKitchen entityKitchen = new EntityKitchen(entityAppartment, description, area, nbgaspoint);
        try {
            return kitchenDAO.insert(entityKitchen);
        } catch (AppartmentException | ConnectionException |  UserException | ManagementException e) {
            throw new LocalException("Impossible de créer une cuisine : "  + e.getMessage());
        }
    }

    @Override
    public void DeleteKitchen(int idAppartment, int idLocal) throws LocalException {
        try {

            if (kitchenDAO.getByPrimaryKey(idLocal).getAppartment().getIdAppartment() == idAppartment)
                kitchenDAO.delete(kitchenDAO.getByPrimaryKey(idLocal));
            else{
                throw new LocalException("Suppression de cette cuisin impossible, le local n'est probablement pas une cuisine");
            }
        }catch (AppartmentException | ConnectionException | LocalException | UserException |ManagementException e){
            throw new LocalException("Supression du local impossible : " + e.getMessage());
        }
    }

}
