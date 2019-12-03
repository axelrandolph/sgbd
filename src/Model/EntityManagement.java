package Model;

public class EntityManagement {

    /*Atttribute*/
    /**
     * The id of the Appartment
     */
    private EntityAppartment entityAppartment;

    /**
     * The id of the user who manage the appartment
     */
    private EntityUser entityUser;


    public EntityManagement(EntityAppartment entityAppartment, EntityUser entityUser) {
        this.entityAppartment = entityAppartment;
        this.entityUser = entityUser;
    }

    /**
     * The default consctructor
     */
    public EntityManagement(){}

    public EntityAppartment getEntityAppartment() {
        return entityAppartment;
    }

    public void setEntityAppartment(EntityAppartment entityAppartment) {
        this.entityAppartment = entityAppartment;
    }

    public EntityUser getEntityUser() {
        return entityUser;
    }

    public void setEntityUser(EntityUser entityUser) {
        this.entityUser = entityUser;
    }
}
