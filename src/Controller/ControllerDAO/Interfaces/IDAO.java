package Controller.ControllerDAO.Interfaces;

import Exception.AppartmentException;
import Exception.BathroomException;
import Exception.BedroomException;
import Exception.ConnectionException;
import Exception.KitchenException;



import java.sql.Connection;

public interface IDAO<T> {

    T insert(T obj) throws AppartmentException, BathroomException, BedroomException, KitchenException;
    void delete(int obj) throws AppartmentException, BathroomException, BedroomException;
    void update(T obj);
    <L> T getByPrimaryKey(L id) throws AppartmentException, BathroomException, BedroomException;
    Connection getConn();
    void setConn(Connection conn);


    }
