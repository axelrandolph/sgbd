package Controller.ControllerManager.Interfaces;

import Model.EntityConnection;

import java.sql.SQLException;

public interface IConnectionManager {

    EntityConnection CreateLocalConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB, int idAppartment) throws SQLException;
}
