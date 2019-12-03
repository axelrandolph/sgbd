package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IUserDAO;
import Model.EntityUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends  DAO<EntityUser> implements IUserDAO {

    @Override
    public EntityUser insert(EntityUser user) {

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
            e.printStackTrace();
        }


        return user;
    }

    @Override
    public void delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityUser user) {

        String sqlUpdate = "UPDATE user "
                + "SET firstName= ?, "
                + "SET lastName = ?,"
                + "SET fonction = ?,"
                + "SET password = ?,"
                + "WHERE username = ?";

        String sql = "UPDATE user SET firstName = ?, lastName = ? ,fonction = ?,password = ? WHERE username = ?";
        try{
            PreparedStatement preparedStmt = getConn().prepareStatement(sql);

            preparedStmt.setString(2,user.getFirstName());
            preparedStmt.setString(3,user.getLastName());
            preparedStmt.setString(4,user.getFunction());
            preparedStmt.setString(1,user.getPassword());
            preparedStmt.setString(5,user.getUserName());


            preparedStmt.executeUpdate();
            preparedStmt.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    private boolean validateUsername(String username) {
        return username.length() > 3;
    }

    private boolean validatePass(String pass) {
        return pass.length() >= 10 & pass.matches(".*\\d+.*");
    }

    public int register(String username, String pass) {
        PreparedStatement prepStmt = null;
        try {
            prepStmt = getConn().prepareStatement("SELECT username, password FROM user WHERE username=?");
            prepStmt.setString(1, username);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) <= 0) {
                if (validatePass(pass) && validateUsername(username)) {
                  //  insertNewUser(username, pass);
                 //   createAccountForUser(username);
                    return 1;
                } else {
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public <L> EntityUser getByPrimaryKey(L username) throws SQLException {

         EntityUser user = new EntityUser();
         String sql = "SELECT * FROM user WHERE username = ?;";

        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, (String)username);
        ResultSet result = pst.executeQuery();
         if(result.first())
            user = new EntityUser(
                    result.getString("username"),
                    result.getString("firstName"),
                    result.getString("lastName"),
                    result.getString("fonction"),
                    result.getString("password")

                    );

        return user;
    }

    @Override
    public EntityUser IdentifiedUser(String username, String password) throws SQLException {

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?;";
        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if (rs.next())
            return getByPrimaryKey(rs.getString("username"));
        return null;
    }
}



