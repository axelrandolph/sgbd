package Model;

public abstract class AbstractEntityLocal {

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

    /**
     * the local type
     */
    protected String typeLocal;

    /* ---------------- Constructors ---------------------*/
    /**
     * A copy Local Constructor
     * @param idLocal
     * @param appartment
     * @param description
     * @param area
     */
    public AbstractEntityLocal(int idLocal, EntityAppartment appartment, String description, float area,String typeLocal) {
        this.idLocal = idLocal;
        this.appartment = appartment;
        this.description = description;
        this.area = area;
        this.typeLocal = typeLocal;
    }

    /**
     * A copy local Constructor
     * @param appartment
     */
    public AbstractEntityLocal(EntityAppartment appartment) {
        this.appartment = appartment;
    }

    /**
     * Default Local Constructor
     */
    public AbstractEntityLocal() {
    }

    public AbstractEntityLocal(EntityAppartment entityAppartment, String description, float area) {
    }

    /* ---------------- Getters & Setters ---------------------*/

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public EntityAppartment getAppartment() {
        return appartment;
    }

    public void setAppartment(EntityAppartment appartment) {
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

    public String getTypeLocal() {
        return typeLocal;
    }

    public void setTypeLocal(String typeLocal) {
        this.typeLocal = typeLocal;
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
