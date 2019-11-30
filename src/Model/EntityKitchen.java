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
    public EntityKitchen(int idLocal, EntityAppartment appartment, String description, float area, int nbGasPoint,String typeLocal) {
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

        this.nbGasPoint = nbGasPoint;
    }


    /* Getters & Setters*/
    public int getNbGasPoint() {
        return nbGasPoint;
    }

    public void setNbGasPoint(int nbGasPoint) {
        this.nbGasPoint = nbGasPoint;
    }
}
