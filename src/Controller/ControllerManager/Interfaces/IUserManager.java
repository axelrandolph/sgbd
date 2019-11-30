package Controller.ControllerManager.Interfaces;

public interface IUserManager {

    public void createUser(String username, String firstname,String lastname,String function, String password);
    public  void loginUser(String username,String password);

}
