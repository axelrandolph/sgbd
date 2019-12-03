package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IUserDAO;
import Model.EntityUser;

import Exception.UserException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends  DAO<EntityUser> implements IUserDAO {

    @Override
    public EntityUser insert(EntityUser user) throws UserException {

        String query = "INSERT INTO user ("
                + " username,"
                + " firstName,"
                + " lastName,"
                + " fonction,"
                + " password" + ") VALUES ("
                + " ?, ?, ?, ?, ?)";
        try {

            // set all the preparedstatement parameters
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setString(1,user.getUserName());
            preparedStmt.setString(2,user.getFirstName());
            preparedStmt.setString(3,user.getLastName());
            preparedStmt.setString(4,user.getFunction());
            preparedStmt.setString(5,user.getPassword());

            // execute the preparedstatement insert
            preparedStmt.executeUpdate();
            preparedStmt.close();


        } catch (SQLException e) {
            throw new UserException("Impossible d'insérer cet utilisateur dans la base de donnée : " + e.getMessage());
        }


        return user;
    }

    @Override
    public void delete(EntityUser obj)  {

    }


    @Override
    public void update(EntityUser user, String firstName, String lastName, String function, String password) throws UserException {


        String sql = "UPDATE user SET firstName = ?, lastName = ? ,fonction = ?,password = ? WHERE username = ?";
        try{
            PreparedStatement preparedStmt = getConn().prepareStatement(sql);

            preparedStmt.setString(1, firstName);
            preparedStmt.setString(2, lastName);
            preparedStmt.setString(3, function);
            preparedStmt.setString(4, password);
            preparedStmt.setString(5,user.getUserName());


            preparedStmt.executeUpdate();
            preparedStmt.close();


        } catch (SQLException e) {
            throw new UserException("L'utilisateur ayant pour username : " + user.getUserName() + " n'a pas pus être mis à jour due à l'erreur suivante  : " + e.getMessage());
        }

    }



    @Override
    public <L> EntityUser getByPrimaryKey(L username) throws UserException {

        try {
            EntityUser user = new EntityUser();
            String sql = "SELECT * FROM user WHERE username = ?;";

            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, (String) username);
            ResultSet result = pst.executeQuery();
            if (result.first())
                user = new EntityUser(
                        result.getString("username"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("fonction"),
                        result.getString("password")

                );
            return user;

        }catch (SQLException e){
            throw new UserException("impossible de récupérer l'utilisateur dans la base de données : "+ e.getMessage());
        }
    }

    @Override
    public EntityUser IdentifiedUser(String username, String password) throws UserException {

        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?;";
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                return getByPrimaryKey(rs.getString("username"));
        }catch (SQLException e){
            throw new UserException("L'utilisateur ayant pour username : " + username + " n'a pas pus être identifié due à l'erreur  : " + e.getMessage() + " \n Veuillez reiterer l'operation.");
        }
        return null;
    }
}



