package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerDAO.Interfaces.IManagementDAO;
import Controller.ControllerDAO.Interfaces.IUserDAO;
import Model.EntityManagement;

import Exception.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManagementDAO extends DAO<EntityManagement> implements IManagementDAO {

    IAppartmentDAO appartmentDAO;
    IUserDAO userDAO;

    public ManagementDAO() {
        this.appartmentDAO = new AppartmentDAO();
        this.userDAO = new UserDAO();
    }

    @Override
    public EntityManagement insert(EntityManagement entityManagement) throws ManagementException {

        String sql = "INSERT INTO management(idAppartment, username) VALUES(?, ?);";
        PreparedStatement pst = null;
        try {
            pst = getConn().prepareStatement(sql);
            pst.setInt(1, entityManagement.getEntityAppartment().getIdAppartment());
            pst.setString(2, entityManagement.getEntityUser().getUserName());


            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            throw new ManagementException("Impossible d'ajouter une liason entre cet appartement et cet utilisateur due au message suivant " + e.getMessage());
        }

        return entityManagement;
    }

    @Override
    public void delete(EntityManagement entityManagement) throws ManagementException {
        String query = "delete from management where idAppartment = ? AND username = ? ;";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, entityManagement.getEntityAppartment().getIdAppartment());
            preparedStmt.setString(2, entityManagement.getEntityUser().getUserName());

            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            throw new ManagementException("Suppression de la liaison entre l'utilisateur et l'appartment impossible : " + e.getMessage());
        }


    }

    public void update(EntityManagement obj) {
    }

    @Override
    public <L> EntityManagement getByPrimaryKey(L id) throws ManagementException {
        throw new ManagementException("Management prend deux valeur comme clef primaire");
    }


    @Override
    public EntityManagement getByPrimaryKey(int idAppartment, String username) throws ManagementException {
        EntityManagement entityManagement = null;
        String query = "select * from management where idAppartment = ? AND username = ?;";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1,  idAppartment);
            preparedStmt.setString(2,  username);

            ResultSet resultSet= preparedStmt.executeQuery();
            if (resultSet.next()){
                entityManagement = new EntityManagement(appartmentDAO.getByPrimaryKey(resultSet.getInt("idAppartment")),
                        userDAO.getByPrimaryKey(resultSet.getString("username")));
            }

        } catch (UserException | AppartmentException | SQLException | ConnectionException | LocalException e) {
            throw new ManagementException("Echec lors de l'obtention de la lisaon entre l'username " + username + " et l'appartùment : " + idAppartment+ " erreur : " + e.getMessage());
        }

        return entityManagement;
    }
}
