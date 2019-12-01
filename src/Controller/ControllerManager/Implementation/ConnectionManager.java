package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Controller.ControllerManager.Interfaces.IConnectionManager;
import Model.AbstractEntityLocal;
import Model.EntityConnection;

import java.sql.SQLException;

public class ConnectionManager implements IConnectionManager {

    private IConnectionDAO connectionDAO;

    @Override
    public EntityConnection CreateLocalConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB, int idAppartment) throws SQLException {

        if (!connectionDAO.IsConnectedLocal(idAppartment,idLocalA,typeLocalA)) {
            connectionDAO.AddLocalToConnectedLocal(idAppartment, idLocalA, typeLocalA);
        }
        if (!connectionDAO.IsConnectedLocal(idAppartment,idLocalB,typeLocalB)) {
            connectionDAO.AddLocalToConnectedLocal(idAppartment, idLocalB, typeLocalB);
        }

        if (!connectionDAO.IsConnection(idLocalA,idLocalB,typeLocalA,typeLocalB)){

            AbstractEntityLocal localA = connectionDAO.getByConnectedLocal(idLocalA, typeLocalA);
            AbstractEntityLocal localB = connectionDAO.getByConnectedLocal(idLocalB, typeLocalB);

            EntityConnection entityConnection = new EntityConnection(localA,localB,typeLocalA,typeLocalB);
            return connectionDAO.insert(entityConnection);
        }

        return null;
    }
}