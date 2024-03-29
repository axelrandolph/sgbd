package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;

import java.sql.SQLException;
import java.util.ArrayList;
import Exception.*;

public interface ILocalManager {

     <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracteristic) throws LocalException;

     void DeleteLocal(int idAppartment, int idLocal, String typeLocal) throws LocalException, ConnectionException;

     ArrayList<AbstractEntityLocal> DisplayLocalByAppartment (int idAppartment);

    }
