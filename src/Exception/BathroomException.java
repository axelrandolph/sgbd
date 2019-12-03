package Exception;

public class BathroomException extends Exception{

    private String message;

    public BathroomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
