package Controller.ControllerDAO.Interfaces;

import java.sql.Connection;

public interface IDAO<T> {

    public abstract boolean insert(T obj);
    public abstract boolean delete(T obj);
    public abstract boolean update(T obj);
    public abstract T find(int id);
    public Connection getConn();
    public void setConn(Connection conn);


    }
