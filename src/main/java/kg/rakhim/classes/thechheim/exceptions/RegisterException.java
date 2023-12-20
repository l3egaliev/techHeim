package kg.rakhim.classes.thechheim.exceptions;

public class RegisterException extends RuntimeException{
    private String message;

    public RegisterException(String message){
        super(message);
    }
}
