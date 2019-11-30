package Model;

public class EntityBathroom extends AbstractEntityLocal {

    /* Attributes */

    /**
     * Number of water point in the bathroom
     */
    private int nbWaterPoint;


    /* Constructors*/
    
    /**
     * A copy Bathroom Constructor
     * @param idLocal
     * @param appartment
     * @param description
     * @param area
     * @param nbWaterPoint
     */
    public EntityBathroom(int idLocal, EntityAppartment appartment, String description, float area, int nbWaterPoint,String typeLocal) {
      super(idLocal, appartment, description, area,typeLocal);
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
