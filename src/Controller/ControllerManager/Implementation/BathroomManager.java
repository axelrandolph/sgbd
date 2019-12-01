package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Controller.ControllerManager.Interfaces.IBathroomManager;
import Model.EntityAppartment;
import Model.EntityBathroom;

import java.sql.SQLException;

public class BathroomManager implements IBathroomManager {

    private IBathroomDAO bathroomDAO;

    @Override
    public EntityBathroom CreateBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) throws SQLException {

        EntityBathroom entityBathroom = new EntityBathroom(entityAppartment, description, area, nbwaterpoint);
        return bathroomDAO.insert(entityBathroom);
    }

    @Override
    public void DeleteBathroom(int idAppartment, int idBathroom){

        bathroomDAO.deleteById(idAppartment,idBathroom);

    }
}