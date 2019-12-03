package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Exception.*;
import Static.StaticName;

public class ConnectionDAO extends DAO<EntityConnection> implements IConnectionDAO {

    private IBathroomDAO bathroomDAO;
    private IBedroomDAO bedroomDAO;
    private IKitchenDAO kitchenDAO;

    public ConnectionDAO() {
        this.kitchenDAO = new KItchenDAO();
        this.bathroomDAO = new BathroomDAO();
        this.bedroomDAO = new BedroomDAO();
    }

    @Override
    public EntityConnection insert(EntityConnection entityConnection) throws ConnectionException {

        String sql = "INSERT INTO connection(idConnectedLocal, idConnectedLocal_2, LocalType, LocalType_2) VALUES(?, ?, ?, ?);";
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, entityConnection.getLocalA().getIdLocal());
            pst.setInt(2, entityConnection.getLocalB().getIdLocal());
            pst.setString(3, entityConnection.getTypeLocalA());
            pst.setString(4, entityConnection.getTypeLocalB());

            pst2 = conn.prepareStatement(sql);
            pst2.setInt(1, entityConnection.getLocalB().getIdLocal());
            pst.setInt(2, entityConnection.getLocalA().getIdLocal());
            pst.setString(3, entityConnection.getTypeLocalB());
            pst.setString(4, entityConnection.getTypeLocalA());

            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new ConnectionException("Connexion impossible due à l'erreur suivante : " + e.getMessage());
        }

        return entityConnection;
    }

    @Override
    public void delete(EntityConnection entityConnection) throws LocalException {
        String query = "delete from connection where idConnectedLocal = ? and idConnectedLocal_2 = ? and LocalType = ? and LocalType_2 = ?";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, entityConnection.getLocalA().getIdLocal());
            preparedStmt.setInt(2, entityConnection.getLocalB().getIdLocal());
            preparedStmt.setString(3, entityConnection.getTypeLocalA());
            preparedStmt.setString(4, entityConnection.getTypeLocalB());

            preparedStmt.executeUpdate();

            PreparedStatement preparedStmt2 = getConn().prepareStatement(query);
            preparedStmt2.setInt(1, entityConnection.getLocalB().getIdLocal());
            preparedStmt2.setInt(2, entityConnection.getLocalA().getIdLocal());
            preparedStmt2.setString(3, entityConnection.getTypeLocalB());
            preparedStmt2.setString(4, entityConnection.getTypeLocalA());

            preparedStmt2.executeUpdate();

            preparedStmt.close();
            preparedStmt2.close();


        } catch (SQLException e) {
            throw new LocalException("Suppression de la connection entre le local d'id : " + entityConnection.getLocalA().getIdLocal() + " et le local d'id : " + entityConnection.getLocalB().getIdLocal() + "due au message suivant : " + e.getMessage());
        }

    }


    @Override
    public <L> EntityConnection getByPrimaryKey(L id) throws ConnectionException {
        throw new ConnectionException("Erreur : Impossible de récupérer l'objet connection à partir d'une clef. Essayer plutôt IsConnection()");
    }

    @Override
    public void AddLocalToConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws ConnectionException {

        try {
            String sql = "INSERT INTO connectedlocal(idConnectedLocal, LocalType, idAppartment) VALUES(?, ?, ?);";
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idLocal);
            pst.setString(2, typeLocal);
            pst.setInt(3, idAppartment);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            throw new ConnectionException("Ajout dans la table connected local impossible due à l'erreur suivante : " + e.getMessage());
        }

    }

    /**
     * @param idAppartment
     * @param idLocal
     * @param typeLocal
     * @return true if Local exist otherwise false
     * @throws SQLException
     */
    @Override
    public boolean IsConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws ConnectionException {

        try {
            String sql = "SELECT * FROM connectedlocal WHERE idAppartment = ? AND idConnectedLocal = ? AND LocalType = ?;";
            PreparedStatement preparedStatement = null;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idAppartment);
            preparedStatement.setInt(2, idLocal);
            preparedStatement.setString(3, typeLocal);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.getInt("idConnectedLocal");
                if (resultSet.wasNull())
                    return false;
            }
        } catch (SQLException e) {
            throw new ConnectionException("Aucun résultat rendu du à l'erreur suivante : " + e.getMessage());
        }

        return true;
    }

    /**
     * @param idLocalA
     * @param idLocalB
     * @param typeLocalA
     * @param typeLocalB
     * @return true if a connection already exist
     * @throws SQLException
     */
    @Override
    public boolean IsConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB) throws ConnectionException {
        String sql = "SELECT * FROM connection WHERE idConnectedLocal = ? AND idConnectedLocal_2 = ? AND LocalType = ? AND LocalType_2 = ?;";

        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idLocalA);
            preparedStatement.setInt(2, idLocalB);
            preparedStatement.setString(3, typeLocalA);
            preparedStatement.setString(4, typeLocalB);
            ResultSet resultSet = preparedStatement.executeQuery();

            PreparedStatement preparedStatement2 = null;
            preparedStatement2 = conn.prepareStatement(sql);
            preparedStatement2.setInt(1, idLocalB);
            preparedStatement2.setInt(2, idLocalA);
            preparedStatement2.setString(3, typeLocalB);
            preparedStatement2.setString(4, typeLocalA);
            ResultSet resultSet2 = preparedStatement2.executeQuery();

            if (resultSet.next() && resultSet2.next()) {
                resultSet.getInt("idConnectedLocal");
                resultSet2.getInt("idConnectedLocal");
                if (resultSet.wasNull() || resultSet2.wasNull())
                    return false;
            }
        } catch (SQLException e) {
            throw new ConnectionException("Aucun résultat rendu du à l'erreur suivante : " + e.getMessage());
        }

        return true;
    }

    @Override
    public AbstractEntityLocal getByConnectedLocal(int idLocal, String typeLocal) throws ConnectionException {

        try {
            if (typeLocal == StaticName.localKitchenType) {
                return kitchenDAO.getByPrimaryKey(idLocal);
            } else if (typeLocal == StaticName.localBathroomType) {
                return bathroomDAO.getByPrimaryKey(idLocal);
            } else if (typeLocal == StaticName.localBedroomType) {
                return bedroomDAO.getByPrimaryKey(idLocal);
            }
        } catch (LocalException | AppartmentException | UserException | ManagementException e) {
            throw new ConnectionException("Impossible d'obtenir notre local par la table conencted local. \n Erreur : " + e.getMessage());
        }

        return null;
    }

    @Override
    public void delete(int idLocal, String typeLocal) throws ConnectionException {
        String query = "delete from connection where idConnectedLocal = ? and LocalType = ?;";
        try {
            PreparedStatement preparedStmt = getConn().prepareStatement(query);
            preparedStmt.setInt(1, idLocal);
            preparedStmt.setString(2, typeLocal);

            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (SQLException e) {
            throw new ConnectionException("Impossible de suprimé les connection du local " + idLocal + " erreur  : " + e.getMessage());
        }


    }
}
