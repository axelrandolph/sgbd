package Controller.ControllerException;

public class UserException extends Exception {

    private String message;

    public UserException(String message){
        this.message = message;
    }

    public UserException(){
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
