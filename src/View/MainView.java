package View;

import Controller.ControllerDAO.Interfaces.IUserDAO;
import Exception.UserException;
import Controller.ControllerManager.Implementation.AppartmentManager;
import Controller.ControllerManager.Implementation.UserManager;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Controller.ControllerManager.Interfaces.IUserManager;
import Model.EntityUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JButton addButton;
    private JTextField descriptionTextField1;
    private JTextField addressTextField1;
    private JLabel stateLabel;
    private JLabel addressLabel;
    private JLabel descriptionField;
    private JRadioButton stateRadioButton;
    private JScrollPane js;
    private JPanel appartPanel;
    private IUserDAO iUserDAO;
    private IUserManager iUserManager;
    private IAppartmentManager iAppartmentManager;
    DefaultTableModel tableModel = new DefaultTableModel(5,4);
    JTable table = new JTable();


    public MainView() {
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

        table.setModel(tableModel);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int currentRow = table.getSelectedRow();
                    int currentColumn = table.getSelectedColumn();
                   JOptionPane.showMessageDialog(null,table.getValueAt(currentRow,currentColumn));
                    iAppartmentManager.CreateAppartment(descriptionField.getText(),addressTextField1.getText(),stateRadioButton.isSelected());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        js.add(table);


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
