package Controller.ControllerManager.UnitTests;



import Controller.ControllerException.UserException;
import Controller.ControllerManager.Implementation.AppartmentManager;
import Controller.ControllerManager.Implementation.UserManager;
import Model.EntityAppartment;
import Model.EntityBedroom;
import Model.EntityUser;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserManagerTest {

    EntityUser user;
    UserManager userManager;

    @Test
    public void TestCreateUser(){
    }

    @Test
    public void TestSearch() throws UserException, SQLException {

        EntityUser user = new EntityUser( "userName","firstName");

        ArrayList<EntityAppartment> listAppart = new ArrayList<EntityAppartment>();
        EntityAppartment appart = new EntityAppartment(1, "address", "description",true);
        listAppart.add(appart);
        EntityBedroom bedroom = new EntityBedroom(1, appart, "description1",3, "type","typeLocal");
        AppartmentManager aptManager = new AppartmentManager();
        assertEquals(listAppart, aptManager.SearchAppartmentByCaracteristics(0, 1, 0, 0, 0, "typeLocal"));
    }
}
