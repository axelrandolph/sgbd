package Model;

public class EntityKitchen {

    /* Attribute*/

    /**
     * The number of gas point in the kitchen
     */
    private int nbGasPoint;

<<<<<<< Updated upstream
    /**
     * Default Constructor
     */
    public EntityKitchen(){
    }

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
>>>>>>> Stashed changes
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
