package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;

import java.sql.SQLException;

public interface ILocalManager {

    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracteristic) throws SQLException;
}
