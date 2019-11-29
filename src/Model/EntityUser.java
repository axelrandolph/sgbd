package Model;

public class EntityUser {


    /**
     * The userName of User
     */
    private String userName;

    /**
     * The userName of User
     */
    private int password;
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
     * @param userName : String
     * @param lastName : String
     * @param firstName : String
     * @param functionUser : String
     */
    public EntityUser( String userName, int password,String lastName, String firstName,String functionUser){

        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.functionUser = functionUser;

    }

    /*Getters & Setters*/

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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getFunctionUser() {
        return functionUser;
    }

    public void setFunctionUser(String functionUser) {
        this.functionUser = functionUser;
    }


    @Override
    public String toString() {
        return "EntityUser{"+
                ", userName='" + userName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", functionUser='" + functionUser + '\'' +
                '}';
    }
}
