package exceptions;

public class PlayerAlreadyHasTeam  extends RuntimeException{
    public PlayerAlreadyHasTeam(String message) {
        super(message);
    }
}
