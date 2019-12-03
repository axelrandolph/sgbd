package Controller.ControllerDAO.Interfaces;

import Exception.AppartmentException;
import Exception.LocalException;
import Exception.ConnectionException;


import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO<T> {

    T insert(T obj) throws AppartmentException, LocalException, ConnectionException, SQLException;
    void delete(T obj) throws AppartmentException, LocalException;
    <L> T getByPrimaryKey(L id) throws AppartmentException, LocalException, SQLException, ConnectionException;
    Connection getConn();
    void setConn(Connection conn);


    }
