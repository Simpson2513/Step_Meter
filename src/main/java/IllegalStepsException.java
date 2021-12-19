public class IllegalStepsException extends IllegalArgumentException {
    public IllegalStepsException(int input) {
        super("Steps must me > 0, your steps - " + input);
    }
}
