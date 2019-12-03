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
    public EntityBathroom(int idLocal, String description, float area, int nbWaterPoint , EntityAppartment appartment, String typeLocal) {
      super(idLocal, appartment, description, area,typeLocal);
        this.nbWaterPoint = nbWaterPoint;
    }

    /**
     *A copy Constructor
     * @param entityAppartment
     * @param nbWaterPoint
     */
    public EntityBathroom(EntityAppartment entityAppartment, int nbWaterPoint) {
        super(entityAppartment);
        this.nbWaterPoint = nbWaterPoint;
    }


    public EntityBathroom(EntityAppartment entityAppartment, String description, float area, int nbwaterpoint) {
        super(entityAppartment, description, area);
        this.nbWaterPoint = nbWaterPoint;
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
