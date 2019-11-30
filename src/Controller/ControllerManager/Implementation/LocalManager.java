package Controller.ControllerManager.Implementation;

import Controller.ControllerManager.Interfaces.*;
import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;

public class LocalManager implements ILocalManager {

    private IKitchenManager kitchenManager;
    private IBathroomManager bathroomManager;
    private IBedroomManager bedroomManager;
    protected IAppartmentManager appartmentManager;

    @Override
    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracterisc) throws SQLException {

        EntityAppartment entityAppartment = appartmentManager.getAppartmentById(idAppartment);
        if(typeLocal == "Bathroom"){
            return bathroomManager.CreateBathroom(entityAppartment, description, area, (int)localCaracterisc);

        }
        else if (typeLocal == "Bedroom"){
            return bedroomManager.CreateBedroom(entityAppartment, description, area, (String) localCaracterisc);

        }
        else if (typeLocal == "Kitchen"){
            return kitchenManager.CreateKitchen(entityAppartment, description, area, (int)localCaracterisc);
        }
        return null;
    }
}
