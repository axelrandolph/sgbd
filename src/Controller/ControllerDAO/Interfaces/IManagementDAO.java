package Controller.ControllerDAO.Interfaces;

import Model.EntityManagement;
import Exception.ManagementException;

public interface IManagementDAO extends IDAO<EntityManagement> {
    EntityManagement getByPrimaryKey(int idAppartment, String username) throws ManagementException;
}