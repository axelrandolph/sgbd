package Controller.ControllerDAO.Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO<T> {

    public abstract T insert(T obj) throws SQLException;
    public abstract boolean delete(T obj);
    public abstract boolean update(T obj);
    public abstract T find(int id);
    public Connection getConn();
    public void setConn(Connection conn);


    }
