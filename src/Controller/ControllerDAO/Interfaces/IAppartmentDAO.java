package Controller.ControllerDAO.Interfaces;

import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAppartmentDAO extends IDAO<EntityAppartment> {
    void CreateOrReplaceAppartmentView(String appartmentView) throws SQLException;

    ArrayList<EntityAppartment> DisplayAppartmentView(String appartmentView) throws SQLException;
}
