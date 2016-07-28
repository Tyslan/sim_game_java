package domain.exceptions;

/**
 * Created by Lorenz on 27/07/2016.
 */
@SuppressWarnings("DefaultFileTemplate")
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("Montant inssuffisant");
    }
}
