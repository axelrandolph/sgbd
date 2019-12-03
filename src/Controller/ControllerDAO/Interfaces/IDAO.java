package Controller.ControllerDAO.Interfaces;

import Exception.AppartmentException;
import Exception.LocalException;
import Exception.ConnectionException;


import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO<T> {

    T insert(T obj) throws AppartmentException, LocalException, ConnectionException, SQLException;
    void delete(int obj) throws AppartmentException, LocalException;
    void update(T obj);
    <L> T getByPrimaryKey(L id) throws AppartmentException, LocalException, SQLException;
    Connection getConn();
    void setConn(Connection conn);


    }
