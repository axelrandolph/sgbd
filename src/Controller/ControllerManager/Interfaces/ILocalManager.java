package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;

public interface ILocalManager {

    public <L> AbstractEntityLocal CreateLocal(int idAppartment, String description, float area, String typeLocal, L localCaracteristic);
}
