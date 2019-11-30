package Controller.ControllerManager.Implementation;

import Controller.ControllerManager.Interfaces.IBathroomManager;
import Controller.ControllerManager.Interfaces.IBedroomManager;
import Controller.ControllerManager.Interfaces.IKitchenManager;
import Controller.ControllerManager.Interfaces.ILocalManager;
import Model.AbstractEntityLocal;

public class LocalManager implements ILocalManager {

    private IKitchenManager kitchenManager;
    private IBathroomManager bathroomManager;
    private IBedroomManager bedroomManager;

    @Override
    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracterisc) {

        if(typeLocal == "Bathroom"){
            return bathroomManager.CreateBathroom(idAppartment, description, area, (int)localCaracterisc);

        }
        else if (typeLocal == "Bedroom"){
            return bedroomManager.CreateBedroom(idAppartment, description, area, (String) localCaracterisc);

        }
        else if (typeLocal == "Kitchen"){
            return kitchenManager.CreateKitchen(idAppartment, description, area, (int)localCaracterisc);
        }
        return null;
    }
}
