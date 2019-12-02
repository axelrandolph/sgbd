package View;

import Controller.ControllerDAO.Interfaces.IUserDAO;
import Controller.ControllerManager.Implementation.UserManager;
import Controller.ControllerManager.Interfaces.IUserManager;
import Model.EntityUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainView extends  JFrame {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JTextField passwordField1;
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
    private JButton loginButton;
    private JButton signinButton;
    private IUserDAO iUserDAO;
    private IUserManager iUserManager;

    public MainView(){
        iUserManager = new UserManager();
        add(panel1);
        setTitle("Manage Appartment");
        setSize(600,500);



        signinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    iUserManager.CreateUser(usernameField1.getText(),lastnameField.getText(),lastnameField.getText(),functionField.getText(),passwordField2.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    iUserManager.LogUser(usernameField.getText(),passwordField1.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
    }


}
