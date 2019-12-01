package Controller.ControllerDAO.Interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO<T> {

    public abstract T insert(T obj) throws SQLException;
    public abstract boolean delete(int obj);
    public abstract boolean update(T obj);
    public abstract <L> T getByPrimaryKey(L id) throws SQLException;
    public Connection getConn();
    public void setConn(Connection conn);


    }
