package chapter4;

public class UnknownNodeException extends Throwable {
    UnknownNodeException(Node node) {
        super("Unknown node: " + node.getLabel());
    }
}
