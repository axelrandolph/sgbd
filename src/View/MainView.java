package View;

import javax.swing.*;

public class MainView extends  JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JButton SIGNINButton;
    private JPasswordField passwordField1;
    private JLabel passwordLabel1;
    private JLabel firstNameLabel;
    private JLabel lastnameLabel;
    private JLabel functionLabel;
    private JLabel usernameLabel1;
    private JTextField usernameField1;
    private JTextField firstnameField;
    private JTextField lastnameField;
    private JTextField functionField;
    private JPasswordField passwordField2;
    private JButton LOGINButton;


    public MainView(){

        add(panel1);
        setTitle("Manage Appartment");
        setSize(500,500);
    }
}
