package Model;

public class EntityConnection {

    /*Attributes*/
    /**
     * Premier local impliqué dans la liaison
     */
    AbstractLocal LocalA;

    /**
     * Second local impliqué dans la liaison
     */
    AbstractLocal LocalB;

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
    public EntityConnection(AbstractLocal localA, AbstractLocal localB, String typeLocalA, String typeLocalB) {
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

    public AbstractLocal getLocalA() {
        return LocalA;
    }

    public void setLocalA(AbstractLocal localA) {
        LocalA = localA;
    }

    public AbstractLocal getLocalB() {
        return LocalB;
    }

    public void setLocalB(AbstractLocal localB) {
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
