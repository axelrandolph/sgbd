package View;

import Controller.ControllerManager.Implementation.AppartmentManager;
import Controller.ControllerManager.Implementation.UserManager;
import Controller.ControllerManager.Interfaces.IAppartmentManager;
import Controller.ControllerManager.Interfaces.IUserManager;
import Exception.*;

import java.security.PrivateKey;
import java.util.Scanner;

public class mainView {

    private IUserManager iUserManager = new UserManager();
    private IAppartmentManager iAppartmentManager = new AppartmentManager();

    private String username, password;
    private String username1, firstname, lastname, function, password1;
    private String description, addresse;

    public mainView() throws AppartmentException {
    }

    public void Affichage() throws UserException, AppartmentException {


        System.out.println("Bienvenue dans l'application\n Tapez 1 : si vous voulez vous vous connecter \n Tapez 2 : si vous " +
                "voulez créer un compte\n ");
        Scanner sc = new Scanner(System.in);
        int j = sc.nextInt();
        sc.close();

        System.out.println("Vous avez choisi : " + j);

        if (j == 1) {
            System.out.println("Username : ");
            username = sc.nextLine();

            System.out.println("Password : ");
            password = sc.nextLine();

            try {
                iUserManager.LogUser(username, password);
            } catch (UserException e) {
                e.printStackTrace();
            }

        } else if (j == 2) {

            System.out.println("Username : ");
            username1 = sc.nextLine();
            System.out.println("Firstname : ");
            firstname = sc.nextLine();
            System.out.println("Lastname : ");
            lastname = sc.nextLine();
            System.out.println("Function : ");
            function = sc.nextLine();
            System.out.println("Password : ");
            password1 = sc.nextLine();

            try {
                iUserManager.CreateUser(username1, firstname, lastname, function, password);
                System.out.println("Votre compte est cree : ");


            } catch (UserException e) {
                e.printStackTrace();
            }


            System.out.println("Bienvenue dans l'onglet Appartment: ");

            System.out.println("  tapez 1 : Si vous voulez Afficher les appartements \n tapez 2 : Si vous voulez Ajouter un appartment ");

            int i = sc.nextInt();
            System.out.println("Vous avez choisi : " + i);

            if (i == 1) {

                try {

                    iAppartmentManager.getAllAppartment();

                } catch (AppartmentException e) {
                    e.printStackTrace();
                }

            } else if (i == 2) {
                description = sc.nextLine();
                addresse = sc.nextLine();
                try {

                    iAppartmentManager.CreateAppartment(description, addresse);

                } catch (AppartmentException e) {
                    e.printStackTrace();
                }


            }

        }


    }






}
