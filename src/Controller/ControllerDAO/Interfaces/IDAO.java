package Controller.ControllerDAO.Interfaces;

import Exception.AppartmentException;
import Exception.LocalException;
import Exception.ConnectionException;
import Exception.UserException;
import Exception.ManagementException;


import java.sql.Connection;

public interface IDAO<T> {

    T insert(T obj) throws AppartmentException, LocalException, ConnectionException, UserException, ManagementException;
    void delete(T obj) throws AppartmentException, LocalException, ManagementException;
    <L> T getByPrimaryKey(L id) throws AppartmentException, LocalException, ConnectionException, UserException, ManagementException;
    Connection getConn();
    void setConn(Connection conn);


    }
