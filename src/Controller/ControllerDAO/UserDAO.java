package Controller.ControllerDAO;

import Model.EntityUser;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends  DAO<EntityUser> {

    @Override
    public boolean insert(EntityUser user) {

        String query = "INSERT INTO user ("
                + " username,"
                + " firstName,"
                + " lastName,"
                + " fonction,"
                + " password," + ") VALUES ("
                + " ?, ?, ?, ?, ?)";
        try {

            // set all the preparedstatement parameters
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setString(1,user.getUserName());
            preparedStmt.setString(2,user.getFirstName());
            preparedStmt.setString(3,user.getLastName());
            preparedStmt.setString(4,user.getFunction());
            preparedStmt.setInt(5,user.getPassword());

            // execute the preparedstatement insert
            preparedStmt.executeUpdate();
            preparedStmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    @Override
    public boolean delete(EntityUser obj) {
        return false;
    }

    @Override
    public boolean update(EntityUser obj) {
        return false;
    }

    @Override
    public EntityUser find(int id) {
        return null;
    }
}
