
package Model;

public class EntityAppartment {


    /* Attributes*/

    /**
     * The appartment id
     */
    private int idAppartment;
    /**
     * The address of the apparment
     */
    private  String address;
    /**
     * The description of the appartment
     */
    private String description;
    /**
     * The state of the appartment. The appartment can be in construction( state = 0) or ready for delivery(state = 1).
     */
    private boolean state;

    /* Constructors*/

    /**
     * This is the default constructor
     */
    public EntityAppartment(){}

    /**
     * This is the copy constructor
     * @param idAppartment : int
     * @param address : String
     * @param description : String
     * @param state : Boolean
     */
    public EntityAppartment(int idAppartment, String address, String description, boolean state){

        this.idAppartment = idAppartment;
        this.address = address;
        this.description = description;
        this.state = state;
    }


    /* Getters & Setters*/
    public int getIdAppartment() {
        return idAppartment;
    }

    public void setIdAppartment(int idAppartment) {
        this.idAppartment = idAppartment;
    }


    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EntityAppartment{" +
                "idAppartment=" + idAppartment +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}
