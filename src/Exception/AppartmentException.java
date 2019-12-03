package Exception;

public class AppartmentException extends Exception {

    private String message;

    public AppartmentException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
