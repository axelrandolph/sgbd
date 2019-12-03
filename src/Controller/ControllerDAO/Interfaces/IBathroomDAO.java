package Controller.ControllerDAO.Interfaces;

import Model.EntityBathroom;

import java.sql.SQLException;

public interface IBathroomDAO extends IDAO<EntityBathroom> {

    EntityBathroom updateAppartment(EntityBathroom entityBathroom, String description, float area, int nbWaterPoint);

}
