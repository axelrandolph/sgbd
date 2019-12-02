package View;

import Controller.ControllerDAO.Interfaces.IUserDAO;
import Controller.ControllerManager.Interfaces.IUserManager;
import Model.EntityUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainView extends  JFrame implements ActionListener{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private JButton SIGNINButton;
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
    private JButton LOGINButton;
    private IUserDAO iUserDAO;
    private IUserManager iUserManager;

    public MainView(){

        add(panel1);
        setTitle("Manage Appartment");
        setSize(600,500);

        SIGNINButton = new JButton();
        SIGNINButton.addActionListener(this);

        LOGINButton = new JButton();
        LOGINButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object  source=e.getSource();

        if  (source== LOGINButton )
            System.out.println("Ici !");
        else if (source==SIGNINButton)
            System.out.println("2eme !");
    }
}
