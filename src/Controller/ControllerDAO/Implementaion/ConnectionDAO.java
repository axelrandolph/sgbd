package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IBathroomDAO;
import Controller.ControllerDAO.Interfaces.IBedroomDAO;
import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Controller.ControllerDAO.Interfaces.IKitchenDAO;
import Model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDAO extends DAO<EntityConnection> implements IConnectionDAO {

    private IBathroomDAO bathroomDAO;
    private IBedroomDAO bedroomDAO;
    private IKitchenDAO kitchenDAO;

    @Override
    public EntityConnection insert(EntityConnection entityConnection) throws SQLException {

        String sql = "INSERT INTO connection(idConnectedLocal, idConnectedLocal_2, LocalType, LocalType_2) VALUES(?, ?, ?, ?);";
        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setInt(1, entityConnection.getLocalA().getIdLocal());
        pst.setInt(2, entityConnection.getLocalB().getIdLocal());
        pst.setString(3, entityConnection.getTypeLocalA());
        pst.setString(4, entityConnection.getTypeLocalB());
        pst.executeUpdate();
        pst.close();

        return entityConnection;
    }

    @Override
    public boolean delete(int obj) {
        return false;
    }

    @Override
    public boolean update(EntityConnection obj) {
        return false;
    }

    @Override
    public <L> EntityConnection getByPrimaryKey(L id) {
        return null;
    }

    @Override
    public void AddLocalToConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws SQLException {

        String sql = "INSERT INTO connectedlocal(idConnectedLocal, LocalType, idAppartment) VALUES(?, ?, ?);";
        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setInt(1, idLocal);
        pst.setString(2, typeLocal);
        pst.setInt(3, idAppartment);
        pst.executeUpdate();
        pst.close();

    }

    /**
     *
     * @param idAppartment
     * @param idLocal
     * @param typeLocal
     * @return true if Local exist otherwise false
     * @throws SQLException
     */
    @Override
    public boolean IsConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws SQLException {

        String sql = "SELECT * FROM connectedlocal WHERE idAppartment = ? AND idConnectedLocal = ? AND LocalType = ?;";
        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,idAppartment);
        preparedStatement.setInt(2, idLocal);
        preparedStatement.setString(3, typeLocal);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.first())
           return true;

        return false;
    }

    /**
     *
     * @param idLocalA
     * @param idLocalB
     * @param typeLocalA
     * @param typeLocalB
     * @return true if a connection already exist
     * @throws SQLException
     */
    @Override
    public boolean IsConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB) throws SQLException {
        String sql = "SELECT * FROM connection WHERE idConnectedLocal = ? AND idConnectedLocal_2 = ? AND LocalType = ? AND LocalType_2 = ?;";

        PreparedStatement preparedStatement = null;
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,idLocalA);
        preparedStatement.setInt(2, idLocalB);
        preparedStatement.setString(3, typeLocalA);
        preparedStatement.setString(4, typeLocalB);
        ResultSet resultSet = preparedStatement.executeQuery();

        PreparedStatement preparedStatement2 = null;
        preparedStatement2 = conn.prepareStatement(sql);
        preparedStatement2.setInt(1,idLocalB);
        preparedStatement2.setInt(2, idLocalA);
        preparedStatement2.setString(3, typeLocalB);
        preparedStatement2.setString(4, typeLocalA);
        ResultSet resultSet2 = preparedStatement2.executeQuery();

        if(resultSet.first() && resultSet2.first())
            return true;

        return false;
    }

    @Override
    public AbstractEntityLocal getByConnectedLocal(int idLocal, String typeLocal) throws SQLException {

        if (typeLocal == "Kitchen"){
            return kitchenDAO.getByPrimaryKey(idLocal);
        }
        else if (typeLocal == "Bathroom"){
            return bathroomDAO.getByPrimaryKey(idLocal);
        }
        else if (typeLocal == "Bedroom"){
            return bedroomDAO.getByPrimaryKey(idLocal);
        }

        return null;
    }
}
