package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Model.EntityBedroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.AppartmentException;
import Exception.ConnectionException;
import Exception.LocalException;

import Static.StaticName;

public class BedroomDAO extends DAO<EntityBedroom> implements IBedroomDAO {

    private IAppartmentDAO appartmentDAO;

    public BedroomDAO() {
        appartmentDAO = new AppartmentDAO();
    }

    @Override
    public EntityBedroom insert(EntityBedroom entityBedroom) throws LocalException {

        String sql = "INSERT INTO bedroom(description, area, bedroomType, idAppartment) VALUES(?, ?, ?, ?);";
        PreparedStatement pst = null;
        try {
            pst = getConn().prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            pst.setString(1, entityBedroom.getDescription());
            pst.setFloat(2, entityBedroom.getArea());
            pst.setString(3, entityBedroom.getTypeBedroom());
            pst.setInt(4, entityBedroom.getAppartment().getIdAppartment());


            pst.executeUpdate();
            ResultSet resultSet = pst.getGeneratedKeys();
            pst.close();
            if (resultSet.next())
                entityBedroom.setIdLocal(resultSet.getInt("idBathroom"));
        } catch (SQLException e) {
            throw new LocalException("Impossible d'ajouter une nouvelle chambre due au message suivant " + e.getMessage());
        }

        return entityBedroom;
    }

    @Override
    public void delete(EntityBedroom entityBedroom) throws LocalException {

        int idBedroom = entityBedroom.getIdLocal();

        String query = "delete from bedroom where idBedroom = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idBedroom);

            preparedStmt.executeUpdate();


        } catch (SQLException e) {
            throw new LocalException("Suppression de la chambre numero " + idBedroom +" impossible : " + e.getMessage());
        }
    }


    @Override
    public <L> EntityBedroom getByPrimaryKey(L idBedroom) throws LocalException {

        EntityBedroom entityBedroom = null;
        String query = "select * from bedroom where idBedroom = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, (Integer) idBedroom);

            ResultSet resultSet= preparedStmt.executeQuery();
            if (resultSet.next()){
                entityBedroom = new EntityBedroom((Integer)idBedroom, resultSet.getString("description"),
                        resultSet.getFloat("area"), resultSet.getString("bedroomType"),
                        appartmentDAO.getByPrimaryKey(resultSet.getInt("idAppartment")),
                        StaticName.localBedroomType);
            }

        } catch (SQLException | AppartmentException | ConnectionException e) {
            throw new LocalException("Echec lors de l'obtention de la chambre numéro " + idBedroom +" due à l'erreur suivante : " + e.getMessage());
        }

        return entityBedroom;
    }

    @Override
    public EntityBedroom updateBedroom(EntityBedroom entityBedroom, String description, float area, String bedroomType) throws LocalException {
        String sql = "UPDATE bedroom " +
                "SET description = ?, " +
                "  area = ?, " +
                "  bedroomType = ? " +
                "WHERE idBedroom = ?";

        try {
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1, description);
            pst.setFloat(2,  area);
            pst.setString(3, bedroomType);
            pst.setInt(4,  entityBedroom.getIdLocal());

            pst.executeUpdate();
            pst.close();
        }catch (SQLException e){
            throw new LocalException("Impossible de mettre a jour la chambre numero : " + entityBedroom.getIdLocal() + " due  à l'erreur suivante : "+ e.getMessage());
        }

        entityBedroom.setDescription(description);
        entityBedroom.setArea(area);
        entityBedroom.setTypeBedroom(bedroomType);

        return entityBedroom;
    }
}


