package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Implementaion.AppartmentDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;

public class AppartmentManager implements IAppartmentManager {

    private AppartmentDAO appartmentDAO;

    public void displayAppartment( int idAppartment){

        appartmentDAO.find(idAppartment);
    }

}
