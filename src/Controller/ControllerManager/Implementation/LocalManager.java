package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Exception.*;
import Exception.AppartmentException;
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
    private IConnectionDAO connectionDAO;

    public LocalManager() throws LocalException {
        if (UserManager.getCurrentUser() != null){
            this.appartmentDAO = new AppartmentDAO();
            this.bathroomManager = new BathroomManager();
            this.bedroomManager = new BedroomManager();
            this.kitchenManager = new KitchenManager();
        }
        else throw new LocalException("Local non conforme");
    }

    @Override
    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracterisc) throws LocalException {

        EntityAppartment entityAppartment = null;
        try {
            entityAppartment = appartmentDAO.getByPrimaryKey(idAppartment);
            if (typeLocal == "Bathroom") {
                return bathroomManager.CreateBathroom(entityAppartment, description, area, (Integer) localCaracterisc);

            } else if (typeLocal == "Bedroom") {
                return bedroomManager.CreateBedroom(entityAppartment, description, area, (String) localCaracterisc);


            } else if (typeLocal == "Kitchen") {
                return kitchenManager.CreateKitchen(entityAppartment, description, area, (Integer) localCaracterisc);
            }
        }catch (AppartmentException | ConnectionException | UserException | ManagementException e){

        }
        return null;
    }

    @Override
    public void DeleteLocal(int idAppartment, int idLocal, String typeLocal) throws LocalException, ConnectionException {

        DeleteLocalDependencies(idLocal, typeLocal);

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

    private void DeleteLocalDependencies(int idLocal, String typeLocal) throws ConnectionException {
        connectionDAO.delete(idLocal, typeLocal);
    }

    @Override
    public ArrayList<AbstractEntityLocal> DisplayLocalByAppartment(int idAppartment) {
        return  null;
    }

}
