package Model;

public class EntityConnection {

    /*Attributes*/
    /**
     * Premier local impliqué dans la liaison
     */
    AbstractEntityLocal LocalA;

    /**
     * Second local impliqué dans la liaison
     */
    AbstractEntityLocal LocalB;

    /**
     * Type de local du LocalA
     */
    String typeLocalA;

    /**
     * Type de local du LocalB
     */
    String typeLocalB;

    /**
     * Default Constructor for connection object
     * @param localA
     * @param localB
     * @param typeLocalA
     * @param typeLocalB
     */
    public EntityConnection(AbstractEntityLocal localA, AbstractEntityLocal localB, String typeLocalA, String typeLocalB) {
        LocalA = localA;
        LocalB = localB;
        this.typeLocalA = typeLocalA;
        this.typeLocalB = typeLocalB;
    }

    /**
     * A copy Constructor for Connection object
     */
    public EntityConnection() {
    }


    /*------------------------------------ Getters & Setters -------------------------------*/

    public AbstractEntityLocal getLocalA() {
        return LocalA;
    }

    public void setLocalA(AbstractEntityLocal localA) {
        LocalA = localA;
    }

    public AbstractEntityLocal getLocalB() {
        return LocalB;
    }

    public void setLocalB(AbstractEntityLocal localB) {
        LocalB = localB;
    }

    public String getTypeLocalA() {
        return typeLocalA;
    }

    public void setTypeLocalA(String typeLocalA) {
        this.typeLocalA = typeLocalA;
    }

    public String getTypeLocalB() {
        return typeLocalB;
    }

    public void setTypeLocalB(String typeLocalB) {
        this.typeLocalB = typeLocalB;
    }
}
