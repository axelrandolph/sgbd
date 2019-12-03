package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Model.EntityBathroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.LocalException;
import Exception.AppartmentException;
import Exception.ConnectionException;

import Static.StaticName;


public class BathroomDAO extends DAO<EntityBathroom> implements IBathroomDAO {

    private IAppartmentDAO appartmentDAO;

    public BathroomDAO() {
        appartmentDAO = new AppartmentDAO();
    }

    @Override
    public EntityBathroom insert(EntityBathroom entityBathroom) throws LocalException {

        String sql = "INSERT INTO bathroom(description, area, nbWaterPoint, idAppartment) VALUES(?, ?, ?, ?);";
        PreparedStatement pst = null;
        try {
            pst = getConn().prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, entityBathroom.getDescription());
            pst.setFloat( 2, entityBathroom.getArea());
            pst.setInt(3, entityBathroom.getNbWaterPoint());
            pst.setInt(4, entityBathroom.getAppartment().getIdAppartment());


            pst.executeUpdate();
            ResultSet resultSet = pst.getGeneratedKeys();
            pst.close();
            if (resultSet.next())
                entityBathroom.setIdLocal(resultSet.getInt("idBathroom"));
        } catch (SQLException e) {
            throw new LocalException("Impossible d'ajouter une nouvelle salle de bain due au message suivant " + e.getMessage());
        }


        return entityBathroom;
    }

    @Override
    public void delete(EntityBathroom entityBathroom) throws LocalException {
        int idBathroom = entityBathroom.getIdLocal();
        String query = "delete from bathroom where idBathroom = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idBathroom);

            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            throw new LocalException("Suppression de la salle de bain impossible : " + e.getMessage());
        }
    }


    @Override
    public <L> EntityBathroom getByPrimaryKey(L idBathroom) throws LocalException {

        EntityBathroom entityBathroom = null;
        String query = "select * from bathroom where idBathroom = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, (Integer) idBathroom);

            ResultSet resultSet = preparedStmt.executeQuery();
            if (resultSet.next()) {
                entityBathroom = new EntityBathroom((Integer) idBathroom, resultSet.getString("description"),
                        resultSet.getFloat("area"), resultSet.getInt("nbWaterPoint"),
                        appartmentDAO.getByPrimaryKey(resultSet.getInt("idAppartment")), StaticName.localBathroomType);
            }

        } catch (SQLException | AppartmentException | ConnectionException e) {
            throw new LocalException("Echec lors de l'obtention de la salle de bain due à l'erreur suivante : " + e.getMessage());
        }

        return entityBathroom;
    }

    @Override
    public EntityBathroom updateBathroom(EntityBathroom entityBathroom, String description, float area, int nbWaterPoint) throws LocalException {
        String sql = "UPDATE bathroom " +
                "SET description = ?, " +
                "  area = ?, " +
                "  nbWaterPoint = ? " +
                "WHERE idBathroom = ?";

        try {
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, description);
            pst.setFloat(2, area);
            pst.setInt(3, nbWaterPoint);
            pst.setInt(4, entityBathroom.getIdLocal());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new LocalException("Impossible de mettre a jour la salle de bain : " + entityBathroom.getIdLocal() + " due  à l'erreur suivante : " + e.getMessage());
        }

        entityBathroom.setDescription(description);
        entityBathroom.setArea(area);
        entityBathroom.setNbWaterPoint(nbWaterPoint);

        return entityBathroom;

    }
}
