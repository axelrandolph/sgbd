package Model;

public class EntityUser {

    /**
     * The id of User
     */
    private int idUser;
    /**
     * The userName of User
     */
    private String userName;
    /**
     * The lastName of User
     */
    private String lastName;
    /**
     * The firstName of User
     */
    private String firstName;
    /**
     * The function of User
     */
    private String functionUser;

    /**
     *  The Default Constructor
     */
    public EntityUser(){}

    /**
     * The Copy Constructor
     * @param idUser : int
     * @param userName : String
     * @param lastName : String
     * @param firstName : String
     * @param functionUser : String
     */
    public EntityUser(int idUser, String userName, String lastName, String firstName,String functionUser){

        this.idUser =idUser;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.functionUser = functionUser;

    }

    /*Getters & Setters*/
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFunction() {
        return functionUser;
    }

    public void setFunction(String functionUser) {
        this.functionUser = functionUser;
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", functionUser='" + functionUser + '\'' +
                '}';
    }
}
