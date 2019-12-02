package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerException.UserException;
import Controller.ControllerManager.Interfaces.*;
import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocalManager implements ILocalManager {

    private IKitchenManager kitchenManager;
    private IBathroomManager bathroomManager;
    private IBedroomManager bedroomManager;
    private IAppartmentDAO appartmentDAO;

    public LocalManager() throws UserException {
        if (UserManager.getCurrentUser() != null){
            this.appartmentDAO = new AppartmentDAO();
            this.bathroomManager = new BathroomManager();
            this.bedroomManager = new BedroomManager();
            this.kitchenManager = new KitchenManager();
        }
        else throw new UserException();
    }

    @Override
    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracterisc) throws SQLException {

        EntityAppartment entityAppartment = appartmentDAO.getByPrimaryKey(idAppartment);
        if(typeLocal == "Bathroom"){
            return bathroomManager.CreateBathroom(entityAppartment, description, area, (Integer) localCaracterisc);

        }
        else if (typeLocal == "Bedroom"){
            return bedroomManager.CreateBedroom(entityAppartment, description, area, (String) localCaracterisc);

        }
        else if (typeLocal == "Kitchen"){
            return kitchenManager.CreateKitchen(entityAppartment, description, area, (Integer) localCaracterisc);
        }
        return null;
    }

    @Override
    public void DeleteLocal(int idAppartment, int idLocal, String typeLocal) {

        if(typeLocal == "Bathroom"){
            bathroomManager.DeleteBathroom(idAppartment, idLocal);

        }
        else if (typeLocal == "Bedroom"){
            bedroomManager.DeleteBedroom(idAppartment, idLocal);

        }
        else if (typeLocal == "Kitchen"){
            kitchenManager.DeleteKitchen(idAppartment, idLocal);
        }
    }

    @Override
    public ArrayList<AbstractEntityLocal> DisplayLocalByAppartment(int idAppartment) {
        return  null;
    }

    @Override
    public void AppartmentViewByCaracteristics(int nbBathroom, int nbBedroom, int nbKitchen, int nbWaterPointByBathroom, int nbGasPointByKitchen, String bedroomType, String appartmentView) throws SQLException {
        bedroomManager.AppartmentViewByCaracteristics(nbBedroom,bedroomType, appartmentView);
        bathroomManager.AppartmentViewByCaracteristics(nbBathroom,nbWaterPointByBathroom, appartmentView);
        kitchenManager.AppartmentViewByCaracteristics(nbKitchen,nbGasPointByKitchen, appartmentView);
    }

}
