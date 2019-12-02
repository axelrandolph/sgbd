package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.BedroomDAO;
import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Controller.ControllerException.UserException;
import Controller.ControllerManager.Interfaces.IBedroomManager;
import Model.EntityAppartment;
import Model.EntityBedroom;

import java.sql.SQLException;

public class BedroomManager implements IBedroomManager {

    private IBedroomDAO bedroomDAO;

    public BedroomManager() throws UserException {
        if(UserManager.getCurrentUser() != null)
            this.bedroomDAO = new BedroomDAO();
        else throw new UserException();
    }

    @Override
    public EntityBedroom CreateBedroom(EntityAppartment entityAppartment, String description, float area, String typeBedroom) throws SQLException {

        EntityBedroom entityBedroom = new EntityBedroom(entityAppartment, description, area, typeBedroom);
        return bedroomDAO.insert(entityBedroom);
    }

    @Override
    public void DeleteBedroom(int idAppartment, int idLocal) {

    }

    @Override
    public void AppartmentViewByCaracteristics(int nbBedroom, String bedroomType, String appartmentView) throws SQLException {
        bedroomDAO.AppartmentViewByCaracteristics(nbBedroom,bedroomType, appartmentView);
    }
}
