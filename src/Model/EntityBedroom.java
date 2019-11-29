package Model;

public class EntityBedroom extends AbstractLocal{

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
