package chapter3;

public class IllegalStackNumberException extends Throwable {
    IllegalStackNumberException(int stackCount) {
        super("String number must be between 0 and " + (stackCount - 1));
    }
}
