package Model;

public class EntityKitchen {

    /**
     * The number of gas point in the kitchen
     */
    private int nbGasPoint;

    public EntityKitchen(){}

    public EntityKitchen(int nbGasPoint){

        this.nbGasPoint = nbGasPoint;
    }


    public int getNbGasPoint() {
        return nbGasPoint;
    }

    public void setNbGasPoint(int nbGasPoint) {
        this.nbGasPoint = nbGasPoint;
    }
}
