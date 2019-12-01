package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IConnectionDAO;
import Controller.ControllerManager.Interfaces.IConnectionManager;
import Model.EntityConnection;

import java.sql.SQLException;

public class ConnectionManager implements IConnectionManager {

    private IConnectionDAO connectionDAO;

    @Override
    public EntityConnection CreateLocalConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB, int idAppartment) throws SQLException {

        //Dabord verifier qu'il n'existe pas 
        connectionDAO.AddLocalToConnectedLocal(idAppartment,idLocalA,typeLocalA);
        connectionDAO.AddLocalToConnectedLocal(idAppartment,idLocalB,typeLocalB);

        return null;
    }
}
