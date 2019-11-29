package Model;

public class EntityAppartment {


    /* Attribute*/
    private int idAppartment;
    private  String address;
    private String description;
    private boolean state;

    /* Constructors*/

    public EntityAppartment(){}

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


}
