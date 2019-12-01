package Controller.ControllerDAO.Interfaces;

import Model.EntityKitchen;

import java.sql.SQLException;

public interface IKitchenDAO extends IDAO<EntityKitchen> {
    void AppartmentViewByCaracteristics(int nbKitchen, int nbGasPointByKitchen, String appartmentView) throws SQLException;
}
