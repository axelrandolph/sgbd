package Controller.ControllerDAO.Interfaces;

import Model.EntityBathroom;

public interface IBathroomDAO extends IDAO<EntityBathroom> {

    public boolean deleteById(int idAppartment, int idBathroom);

}
