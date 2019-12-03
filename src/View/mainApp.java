package View;

import Controller.ControllerManager.Interfaces.IUserManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainApp extends JFrame {

    private JPanel contentPane;
    private JTextField usernametextField;
    private JTextField passwordtextField;
    private JTextField textField;
    private JTextField fisrtnametextField_1;
    private JTextField lastnametextField_1;
    private JTextField functiontextField_2;
    private JPasswordField passwordField;
    private JTextField textField_1;
    private JTextField addresstextField_2;
    private JTable table;
    private JTextField idApparttextField_2;
    private JTable table_1;
    private JTextField nbWaterPtextField;
    private JTextField typeBedroomtextField;
    private JTextField nbGasPointextField;
    private JTextField nbBathroomtextField;
    private JTextField nbBedroomtextField;
    private JTextField nbKitchentextField;
    private JTable table_2;
    private IUserManager iUserManager;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainApp frame = new mainApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public mainApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1143, 716);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane);

        JPanel panel = new JPanel();
        tabbedPane.addTab("Connexion", null, panel, null);
        panel.setLayout(null);

        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setBounds(15, 16, 87, 20);
        panel.add(lblUsername);

        usernametextField = new JTextField();
        usernametextField.setBounds(117, 13, 146, 26);
        panel.add(usernametextField);
        usernametextField.setColumns(10);

        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(297, 16, 87, 20);
        panel.add(lblPassword);

        passwordtextField = new JTextField();
        passwordtextField.setBounds(385, 13, 146, 26);
        panel.add(passwordtextField);
        passwordtextField.setColumns(10);

        JButton btnLogIn = new JButton("LOG IN");
        btnLogIn.setBounds(572, 12, 115, 29);
        panel.add(btnLogIn);

        JLabel lblUsername_1 = new JLabel("Username : ");
        lblUsername_1.setBounds(15, 123, 87, 20);
        panel.add(lblUsername_1);

        textField = new JTextField();
        textField.setBounds(117, 120, 146, 26);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblFirstname = new JLabel("Firstname : ");
        lblFirstname.setBounds(15, 173, 87, 20);
        panel.add(lblFirstname);

        fisrtnametextField_1 = new JTextField();
        fisrtnametextField_1.setBounds(117, 170, 146, 26);
        panel.add(fisrtnametextField_1);
        fisrtnametextField_1.setColumns(10);

        JLabel lblLastname = new JLabel("Lastname :");
        lblLastname.setBounds(15, 224, 87, 20);
        panel.add(lblLastname);

        lastnametextField_1 = new JTextField();
        lastnametextField_1.setBounds(117, 221, 146, 26);
        panel.add(lastnametextField_1);
        lastnametextField_1.setColumns(10);

        JLabel lblFunction = new JLabel("Function : ");
        lblFunction.setBounds(15, 282, 87, 20);
        panel.add(lblFunction);

        functiontextField_2 = new JTextField();
        functiontextField_2.setBounds(117, 279, 146, 26);
        panel.add(functiontextField_2);
        functiontextField_2.setColumns(10);

        JLabel lblPassword_1 = new JLabel("Password : ");
        lblPassword_1.setBounds(15, 345, 87, 20);
        panel.add(lblPassword_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(117, 342, 146, 26);
        panel.add(passwordField);

        JButton btnSignIn = new JButton("SIGN IN");
        btnSignIn.setBounds(490, 220, 115, 29);
        btnSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    iUserManager.CreateUser(usernameField1.getText(),lastnameField.getText(),lastnameField.getText(),functionField.getText(),passwordField2.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });

        panel.add(btnSignIn);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Appartment", null, panel_2, null);
        panel_2.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel_2.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnUpdate = new JButton("UPDATE");
        panel_1.add(btnUpdate);

        JButton btnDelete = new JButton("DELETE");
        panel_1.add(btnDelete);

        JLabel lblDescription = new JLabel("Description : ");
        panel_1.add(lblDescription);

        textField_1 = new JTextField();
        panel_1.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblAddress = new JLabel("Address : ");
        panel_1.add(lblAddress);

        addresstextField_2 = new JTextField();
        panel_1.add(addresstextField_2);
        addresstextField_2.setColumns(10);

        JLabel lblStatus = new JLabel("Status :");
        panel_1.add(lblStatus);

        JRadioButton radioButton = new JRadioButton("");
        panel_1.add(radioButton);

        JButton btnAdd = new JButton("ADD");
        panel_1.add(btnAdd);

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_2.add(scrollPane_1, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "idAppartment", "description","address","state"
                }
        ));
        scrollPane_1.setViewportView(table);

        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("Local", null, panel_3, null);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4);

        JLabel lblIdappartment = new JLabel("idAppartment :");
        panel_4.add(lblIdappartment);

        idApparttextField_2 = new JTextField();
        panel_4.add(idApparttextField_2);
        idApparttextField_2.setColumns(10);

        JButton btnDisplay = new JButton("Display");
        panel_4.add(btnDisplay);

        JScrollPane scrollPane_2 = new JScrollPane();
        panel_3.add(scrollPane_2, BorderLayout.NORTH);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "idLocal", "description","type","idAppartment"
                }
        ));
        scrollPane_2.setViewportView(table_1);

        JPanel panel_5 = new JPanel();
        tabbedPane.addTab("Search", null, panel_5, null);
        panel_5.setLayout(new BorderLayout(0, 0));

        JPanel panel_6 = new JPanel();
        panel_5.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNumberBedroom = new JLabel("Type Bedroom : ");
        panel_6.add(lblNumberBedroom);

        typeBedroomtextField = new JTextField();
        panel_6.add(typeBedroomtextField);
        typeBedroomtextField.setColumns(10);

        JLabel lblNumKitchen = new JLabel("Num Kitchen : ");
        panel_6.add(lblNumKitchen);

        nbKitchentextField = new JTextField();
        panel_6.add(nbKitchentextField);
        nbKitchentextField.setColumns(10);

        JLabel lblNumBedroom = new JLabel("Num Bedroom :");
        panel_6.add(lblNumBedroom);

        nbBedroomtextField = new JTextField();
        panel_6.add(nbBedroomtextField);
        nbBedroomtextField.setColumns(10);

        JLabel lblNumBathron = new JLabel("Num Bathroom : ");
        panel_6.add(lblNumBathron);

        nbBathroomtextField = new JTextField();
        panel_6.add(nbBathroomtextField);
        nbBathroomtextField.setColumns(10);

        JButton btnSearch = new JButton("SEARCH");
        panel_6.add(btnSearch);

        JLabel lblType = new JLabel("Number GasPoint : ");
        panel_6.add(lblType);

        nbGasPointextField = new JTextField();
        panel_6.add(nbGasPointextField);
        nbGasPointextField.setColumns(10);

        JLabel lblNumberBathroom = new JLabel("Number WaterPoint:");
        panel_6.add(lblNumberBathroom);

        nbWaterPtextField = new JTextField();
        panel_6.add(nbWaterPtextField);
        nbWaterPtextField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        panel_5.add(scrollPane, BorderLayout.NORTH);

        table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "idAppartment", "Description", "Address", "State"
                }
        ));
        scrollPane.setViewportView(table_2);


    }
}
