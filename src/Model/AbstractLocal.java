package Model;

public class AbstractLocal {

    /*Attributes*/

    /**
     * the Local id
     */
    protected int idLocal;

    /**
     * the Appartment connected to
     */
    protected EntityAppartment appartment;

    /**
     * The local description
     */
    protected String description;

    /**
     * the local area
     */
    protected float area;

    /* ---------------- Constructors ---------------------*/
    /**
     * A copy Local Constructor
     * @param idLocal
     * @param appartment
     * @param description
     * @param area
     */
    public AbstractLocal(int idLocal, EntityAppartment appartment, String description, float area) {
        this.idLocal = idLocal;
        this.appartment = appartment;
        this.description = description;
        this.area = area;
    }

    /**
     * A copy local Constructor
     * @param appartment
     */
    public AbstractLocal(EntityAppartment appartment) {
        this.appartment = appartment;
    }

    /**
     * Default Local Constructor
     */
    public AbstractLocal() {
    }

    /* ---------------- Getters & Setters ---------------------*/

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public EntityAppartment getIdAppartment() {
        return appartment;
    }

    public void setIdAppartment(EntityAppartment appartment) {
        this.appartment = appartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "AbstractLocal{" +
                "idLocal=" + idLocal +
                ", Appartment=" + appartment.toString() +
                ", description='" + description + '\'' +
                ", area=" + area +
                '}';
    }


}
