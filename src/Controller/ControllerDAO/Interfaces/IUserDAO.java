package Controller.ControllerDAO.Interfaces;

import Model.EntityUser;
import Exception.UserException;

public interface IUserDAO extends IDAO<EntityUser> {

<<<<<<< HEAD
    EntityUser IdentifiedUser(String username, String password) throws UserException;

    void update(EntityUser user, String firstName, String lastName, String function, String password) throws UserException;

=======
    EntityUser IdentifiedUser(String username, String password) throws SQLException;

    void update(EntityUser user);
>>>>>>> f17f947837fb38939b260831cc87412132f9d602
}
