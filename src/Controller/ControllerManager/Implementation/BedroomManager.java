package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.BedroomDAO;
import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Exception.* ;
import Controller.ControllerManager.Interfaces.IBedroomManager;
import Model.EntityAppartment;
import Model.EntityBedroom;

public class BedroomManager implements IBedroomManager {

    private IBedroomDAO bedroomDAO;

    public BedroomManager() throws LocalException {
        if(UserManager.getCurrentUser() != null)
            this.bedroomDAO = new BedroomDAO();
        else throw new LocalException("Veuillez Connecter un utilisateur");
    }

    @Override
    public EntityBedroom CreateBedroom(EntityAppartment entityAppartment, String description, float area, String typeBedroom) throws LocalException {

        EntityBedroom entityBedroom = new EntityBedroom(entityAppartment, description, area, typeBedroom);
        try {
            return bedroomDAO.insert(entityBedroom);
        }catch (ConnectionException | AppartmentException | UserException e){
            throw new LocalException ("Impossible de créer cette salle de bain : " + e.getMessage());
        }
    }

    @Override
    public void DeleteBedroom(int idAppartment, int idLocal) {

    }

}
