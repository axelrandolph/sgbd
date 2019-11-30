package Model;

public class EntityBedroom extends AbstractEntityLocal {

    /*Attribute*/

    /**
     * The type of Bedroom. It can be simple of double
     */
    private String typeBedroom;

    /*Constructors*/

    /**
     * The default constructor
     */
    public EntityBedroom(){}

    /**
     * The copy constructor
     * @param typeBedroom : String
     */
    public EntityBedroom(String typeBedroom){
        this.typeBedroom = typeBedroom;
    }

    /**
     * A copy Bathroom Constructor
     * @param idLocal
     * @param appartment
     * @param description
     * @param area
     * @param type
     */
    public EntityBedroom(int idLocal, EntityAppartment appartment, String description, float area, String type,String typeLocal) {
        super(idLocal, appartment, description, area,typeLocal);
        this.typeBedroom = type;
    }

    /*Getters & Setters*/
    public String getTypeBedroom() {
        return typeBedroom;
    }

    public void setTypeBedroom(String typeBedroom) {
        this.typeBedroom = typeBedroom;
    }

    public String toString() {
        return "EntityBedroom{" +
                "typeBedroom='" + typeBedroom + '\'' +
                '}';
    }
}
