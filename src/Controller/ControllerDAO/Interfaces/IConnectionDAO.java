package Controller.ControllerDAO.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityConnection;

import java.sql.SQLException;

public interface IConnectionDAO extends IDAO<EntityConnection> {


    void AddLocalToConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws SQLException;

    boolean IsConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws SQLException;

    boolean IsConnection(int idLocalA, int idLocalB, String typeLocalA, String typeLocalB) throws SQLException;

    AbstractEntityLocal getByConnectedLocal(int idLocalA, String typeLocalA) throws SQLException;
}
