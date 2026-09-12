package expense;

public class ExpenseException extends Exception {

    private static final long serialVersionUID = 1L;

    public ExpenseException(String message) {
        super(message);
    }
}