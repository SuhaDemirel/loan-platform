package exception;

public class LoanUnpaidInstallmentNotFoundException extends RuntimeException{
    public LoanUnpaidInstallmentNotFoundException(String message) {
        super(message);
    }
}
