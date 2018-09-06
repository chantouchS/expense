public class OverExpenseException extends Throwable {
    public OverExpenseException() {}
    public OverExpenseException(String reason) {
        super(reason);
    }
}
