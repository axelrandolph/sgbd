package Controller.ControllerDAO.Interfaces;

import Model.EntityBedroom;

import java.sql.SQLException;

public interface IBedroomDAO extends IDAO<EntityBedroom> {
    void AppartmentViewByCaracteristics(int nbBedroom, String bedroomType, String appartmentView) throws SQLException;
}
