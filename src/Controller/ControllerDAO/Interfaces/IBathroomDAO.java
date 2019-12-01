package Controller.ControllerDAO.Interfaces;

import Model.EntityBathroom;

import java.sql.SQLException;

public interface IBathroomDAO extends IDAO<EntityBathroom> {

    public boolean deleteById(int idAppartment, int idBathroom);

    void AppartmentViewByCaracteristics(int nbBathroom, int nbWaterPointByBathroom, String appartmentView) throws SQLException;
}
