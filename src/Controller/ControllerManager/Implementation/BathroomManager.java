package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.BathroomDAO;
import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Exception.LocalException;
import Controller.ControllerManager.Interfaces.IBathroomManager;
import Model.EntityAppartment;
import Model.EntityBathroom;
import Exception.*;

public class BathroomManager implements IBathroomManager {

    private IBathroomDAO bathroomDAO;

    public BathroomManager() throws LocalException {
        if(UserManager.getCurrentUser() != null)
            this.bathroomDAO = new BathroomDAO();
        else throw new LocalException(" Veuillez vous s'authentifier ");
    }

    @Override
    public EntityBathroom CreateBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) throws LocalException {

        EntityBathroom entityBathroom = new EntityBathroom(entityAppartment, description, area, nbwaterpoint);
        try {
                return bathroomDAO.insert(entityBathroom);
            } catch (LocalException | ConnectionException | AppartmentException | UserException | ManagementException e) {
            throw  new LocalException("Cette sdb n'est pas créer");
        }

    }

    @Override
    public void DeleteBathroom(int idAppartment, int idLocal) throws LocalException {

        try {

            if (bathroomDAO.getByPrimaryKey(idLocal).getAppartment().getIdAppartment() == idAppartment)
                bathroomDAO.delete(bathroomDAO.getByPrimaryKey(idLocal));
            else{
                throw new LocalException("Suppression de cette salle de bain impossible, le local n'est probablement pas une cuisine");
            }
        }catch (AppartmentException | ConnectionException | LocalException | UserException |ManagementException e){
            throw new LocalException("Supression du local impossible : " + e.getMessage());
        }
    }

}


