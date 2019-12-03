package Controller.ControllerDAO.Implementaion;

import Controller.ControllerDAO.Interfaces.IDAO;
import Exception.AppartmentException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exception.LocalException;
import Exception.ConnectionException;
import Exception.UserException;
import Exception.ManagementException;


public abstract class DAO<T> implements IDAO<T> {

    protected Connection conn;

    /*Constructor*/

    public DAO(){
        initConnection();
    }

    protected void initConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.exit(1);
        }
        try {
            String serverName = "localhost";
            String mydatabase = "tpbdnote";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase+"?serverTimezone=UTC";

            String username = "root";
            String password = "";
            conn=DriverManager.getConnection(url,username,password);
        }catch (SQLException ex2) {
            System.exit(1);
        }
    }



    /**
     * Create Method
     * @param obj
     * @return boolean
     */
    public abstract T insert(T obj) throws AppartmentException, LocalException, ConnectionException, UserException, ManagementException;

    /**
     * Delete Method
     * @param obj
     */
    public abstract void delete(T obj) throws AppartmentException, LocalException, ManagementException;


    /*Getters & Setters*/
    @Override
    public Connection getConn() {

        return conn;
    }

    @Override
    public void setConn(Connection conn) {

        this.conn = conn;
    }


}
