package Controller.ControllerDAO.Interfaces;

import Model.EntityUser;
import Exception.UserException;

public interface IUserDAO extends IDAO<EntityUser> {

    EntityUser IdentifiedUser(String username, String password) throws UserException;

    void update(EntityUser user, String firstName, String lastName, String function, String password) throws UserException;

}
