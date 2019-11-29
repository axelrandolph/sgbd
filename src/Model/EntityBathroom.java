package Model;

public class EntityBathroom extends AbstractLocal{

    /**
     * Number of water point in the bathroom
     */
    private int nbWaterPoint;

    /**
     * A copy Bathroom Constructor
     * @param idLocal
     * @param appartment
     * @param description
     * @param area
     * @param nbWaterPoint
     */
    public EntityBathroom(int idLocal, EntityAppartment appartment, String description, float area, int nbWaterPoint) {
        super(idLocal, appartment, description, area);
        this.nbWaterPoint = nbWaterPoint;
    }

    /**
     *A copy Constructor
     * @param appartment
     * @param nbWaterPoint
     */
    public EntityBathroom(EntityAppartment appartment, int nbWaterPoint) {
        super(appartment);
        this.nbWaterPoint = nbWaterPoint;
    }

    /**
     * Default Bathroom Constructor
     */
    public EntityBathroom() {
    }

    /*
    Getters and Setters
     */
    public int getNbWaterPoint() {
        return nbWaterPoint;
    }

    public void setNbWaterPoint(int nbWaterPoint) {
        this.nbWaterPoint = nbWaterPoint;
    }


}
