package Exception;

public class UserException extends Exception {

    private String message;

    public UserException(String message){
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
