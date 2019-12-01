package Controller.ControllerManager.Implementation;

import Controller.ControllerDAO.Interfaces.IAppartmentDAO;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public class AppartmentManager implements IAppartmentManager {

    private IAppartmentDAO appartmentDAO;

    @Override
    public EntityAppartment CreateAppartment(String description, String adresse) throws SQLException {

        EntityAppartment entityAppartment = new EntityAppartment(description,adresse, false);
        entityAppartment = appartmentDAO.insert(entityAppartment);

        return entityAppartment;
    }

    @Override
    public EntityAppartment getAppartmentById(int idAppartment) throws SQLException {

        appartmentDAO.getByPrimaryKey(idAppartment);
        return null;
    }

    @Override
    public void DisplayAppartment(int idAppartment) throws SQLException {

        appartmentDAO.getByPrimaryKey(idAppartment);
    }

    @Override
    public void DeleteAppartment(int idAppartment){

        appartmentDAO.delete(idAppartment);
    }

}
