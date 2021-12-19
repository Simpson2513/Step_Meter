public class IllegalDayException extends IllegalArgumentException {
    public IllegalDayException(int input) {
        super("Day must be 1 - 365, your day - " + input);
    }
}
