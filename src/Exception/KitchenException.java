package Exception;

public class KitchenException extends Exception {

    private String message;

    public KitchenException(String message){
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
