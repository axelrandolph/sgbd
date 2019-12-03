package Controller.ControllerDAO.Interfaces;

import Model.EntityBedroom;
import Exception.LocalException;


public interface IBedroomDAO extends IDAO<EntityBedroom> {

    EntityBedroom updateBedroom (EntityBedroom entityBedroom, String description, float area, String bedroomType) throws LocalException;

}
