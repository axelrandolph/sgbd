package Model;

public class EntityKitchen extends AbstractEntityLocal{

    /* Attributes*/

    /**
     * The number of gas point in the kitchen
     */
    private int nbGasPoint;


    /* Constructor*/

    /**
     * A copy Bathroom Constructor
     * @param idLocal
     * @param appartment
     * @param description
     * @param area
     * @param nbGasPoint
     */
    public EntityKitchen(int idLocal, String description, float area, int nbGasPoint,EntityAppartment appartment, String typeLocal) {
        super(idLocal, appartment, description, area,typeLocal);
        this.nbGasPoint = nbGasPoint;
    }
    /**
     * The default constructor
     */
    public EntityKitchen(){}

    /**
     * The copy constructor
     * @param nbGasPoint
     */
    public EntityKitchen(int nbGasPoint){
        super();
        this.nbGasPoint = nbGasPoint;
    }

    public EntityKitchen(EntityAppartment entityAppartment, String description, float area, int nbgaspoint) {
        super(entityAppartment, description, area);

    }


    /* Getters & Setters*/
    public int getNbGasPoint() {
        return nbGasPoint;
    }

    public void setNbGasPoint(int nbGasPoint) {
        this.nbGasPoint = nbGasPoint;
    }
}
