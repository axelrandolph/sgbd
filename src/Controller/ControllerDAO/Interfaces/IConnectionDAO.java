package Controller.ControllerDAO.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityConnection;

import java.sql.SQLException;
import Exception.ConnectionException;

public interface IConnectionDAO extends IDAO<EntityConnection> {


    void AddLocalToConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws  ConnectionException;

    boolean IsConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws  ConnectionException;

    boolean IsConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB) throws  ConnectionException;

    AbstractEntityLocal getByConnectedLocal(int idLocalA, String typeLocalA) throws  ConnectionException;

}
