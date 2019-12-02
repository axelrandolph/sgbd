package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ILocalManager {

    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracteristic) throws SQLException;

    public void DeleteLocal(int idAppartment, int idLocal, String typeLocal);

    public ArrayList<AbstractEntityLocal> DisplayLocalByAppartment (int idAppartment);

    }
