package Controller.ControllerDAO.Interfaces;

import Controller.ControllerDAO.Implementaion.DAO;
import Model.EntityUser;

import java.sql.SQLException;

public interface IUserDAO extends IDAO<EntityUser> {

    EntityUser IdentifiedUser(String username, String password) throws SQLException;

    void update(EntityUser user);
}
