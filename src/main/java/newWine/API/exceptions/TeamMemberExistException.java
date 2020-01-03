package newWine.API.exceptions;

public class TeamMemberExistException extends Exception {
    private static final long serialVersionUID = -8574329628048552450L;

    public TeamMemberExistException(String message) {
        super(message);
    }
}
