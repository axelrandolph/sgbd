package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.EntityKitchen;

import Exception.KitchenException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KItchenDAO extends DAO<EntityKitchen> implements IKitchenDAO {

    private IAppartmentDAO appartmentDAO;

    public KItchenDAO() {
        appartmentDAO = new AppartmentDAO();
    }

    @Override
    public EntityKitchen insert(EntityKitchen entityKitchen) throws KitchenException {
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
            throw new KitchenException("Impossible d'ajouter une nouvelle chambre due au message suivant " + e.getMessage());
        }

        return entityBedroom;
    }

    @Override
    public void delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityKitchen obj) {
        return false;
    }

    @Override
    public <L> EntityKitchen getByPrimaryKey(L id) {
        return null;
    }

}
