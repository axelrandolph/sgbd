package Controller.ControllerDAO.Interfaces;

import Model.EntityConnection;

import java.sql.SQLException;

public interface IConnectionDAO extends IDAO<EntityConnection> {


    void AddLocalToConnectedLocal(int idAppartment, int idLocal, String typeLocal) throws SQLException;
}
