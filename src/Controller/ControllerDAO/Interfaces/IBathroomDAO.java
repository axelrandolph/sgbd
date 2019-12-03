package Controller.ControllerDAO.Interfaces;

import Model.EntityBathroom;

import Exception.LocalException;

public interface IBathroomDAO extends IDAO<EntityBathroom> {

    EntityBathroom updateBathroom(EntityBathroom entityBathroom, String description, float area, int nbWaterPoint) throws LocalException;

}
