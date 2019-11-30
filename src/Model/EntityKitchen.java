package Model;

public class EntityKitchen extends AbstractEntityLocal{

    /* Attributes*/

    /**
     * The number of gas point in the kitchen
     */
    private int nbGasPoint;

    /**
     * A copy Constructor for Kitchen object
=======
    /* Constructor*/

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
