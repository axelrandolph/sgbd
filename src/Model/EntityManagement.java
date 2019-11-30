package Model;

public class EntityManagement {

    /*Atttribute*/
    /**
     * The id of the Appartment
     */
    private int idAppartment;

    /**
     * The id of the user who manage the appartment
     */
    private int idUser;


    /**
     * The default consctructor
     */
    public EntityManagement(){}

    /**
     * The default consctructor
     */
    public EntityManagement(int idAppartment, int idUser){

        this.idAppartment = idAppartment;
        this.idUser = idUser;
    }

    /*Getters & Setters*/
    public int getIdAppartment() {
        return idAppartment;
    }

    public void setIdAppartment(int idAppartment) {
        this.idAppartment = idAppartment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


}
