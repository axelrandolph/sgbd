package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.util.ArrayList;

public interface IAppartmentManager {

    public EntityAppartment CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals);
}
