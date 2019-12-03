package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.EntityKitchen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exception.LocalException;
import Exception.AppartmentException;
import Exception.ConnectionException;
import  Exception.UserException;
import Static.StaticName;

public class KItchenDAO extends DAO<EntityKitchen> implements IKitchenDAO {

    private IAppartmentDAO appartmentDAO;

    public KItchenDAO() {
        appartmentDAO = new AppartmentDAO();
    }

    @Override
    public EntityKitchen insert(EntityKitchen entityKitchen) throws LocalException {
        String sql = "INSERT INTO kitchen(description, area, nbGasPoint, idAppartment) VALUES(?, ?, ?, ?);";
        PreparedStatement pst = null;
        try {
            pst = getConn().prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, entityKitchen.getDescription());
            pst.setFloat(2, entityKitchen.getArea());
            pst.setInt(3, entityKitchen.getNbGasPoint());
            pst.setInt(4, entityKitchen.getAppartment().getIdAppartment());


            pst.executeUpdate();
            ResultSet resultSet = pst.getGeneratedKeys();
            pst.close();
            if (resultSet.next())
                entityKitchen.setIdLocal(resultSet.getInt("idKitchen"));
        } catch (SQLException e) {
            throw new LocalException("Impossible d'ajouter une nouvelle cuisine due au message suivant " + e.getMessage());
        }

        return entityKitchen;
    }

    @Override
    public void delete(EntityKitchen entityKitchen) throws LocalException {

        String query = "delete from kitchen where idKitchen = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, entityKitchen.getIdLocal());

            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            throw new LocalException("Suppression de la cuisine numero " + entityKitchen.getIdLocal() +" impossible : " + e.getMessage());
        }

    }


    @Override
    public <L> EntityKitchen getByPrimaryKey(L idKitchen) throws LocalException{


        EntityKitchen entityKitchen = null;
        String query = "select * from kitchen where idKitchen = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, (Integer) idKitchen);

            ResultSet resultSet= preparedStmt.executeQuery();
            if (resultSet.next()){
                entityKitchen = new EntityKitchen((Integer)idKitchen, resultSet.getString("description"),
                        resultSet.getFloat("area"), resultSet.getInt("nbGasPoint"),
                        appartmentDAO.getByPrimaryKey(resultSet.getInt("idAppartment")), StaticName.localKitchenType);
            }

        } catch (SQLException | AppartmentException | ConnectionException | UserException e) {
            throw new LocalException("Echec lors de l'obtention de la cuisine numéro " + idKitchen +" due à l'erreur suivante : " + e.getMessage());
        }

        return entityKitchen;
    }

}
