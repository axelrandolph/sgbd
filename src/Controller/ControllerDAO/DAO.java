package Controller.ControllerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {

    private Connection conn;

    /*Constructor*/

    public DAO(){
        super();
        initConnection();
    }

    public  void initConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex1) {
            System.out.println("Pilote non trouve!");
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
            System.out.println("Erreur JDBC: "+ex2);
            System.exit(1);
        }
    }



    /**
     * Create Method
     * @param obj
     * @return boolean
     */
    public abstract boolean insert(T obj);

    /**
     * Delete Method
     * @param obj
     * @return boolean
     */
    //public abstract boolean delete(T obj);

    /**
     * Update Method
     * @param obj
     * @return boolean
     */
   // public abstract boolean update(T obj);

    /**
     * Find Method
     * @param id
     * @return T
     */
    //public abstract T find(int id);


    /*Getters & Setters*/
    public Connection getConn() {

        return conn;
    }

    public void setConn(Connection conn) {

        this.conn = conn;
    }


}
