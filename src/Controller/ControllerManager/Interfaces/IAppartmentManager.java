package Controller.ControllerManager.Interfaces;

import Model.AbstractEntityLocal;
import Model.EntityAppartment;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAppartmentManager {

    /**
     *
     * @param description
     * @param adresse
     * @param listLocals
     * @return
     * @throws SQLException
     */
    public EntityAppartment CreateAppartment(String description, String adresse, ArrayList<AbstractEntityLocal> listLocals) throws SQLException;

    /**
     *
     * @param idAppartment
     */
    public void DisplayAppartment(int idAppartment);

        /*----------------------- Getters & Setters ---------------------- */

    /**
     *
     * @param idAppartment
     * @return
     */
    public EntityAppartment getAppartmentById(int idAppartment);
}
