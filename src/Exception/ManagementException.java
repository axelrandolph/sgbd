package Exception;

public class ManagementException extends Exception {

    private String message;

    public ManagementException(String message){
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
