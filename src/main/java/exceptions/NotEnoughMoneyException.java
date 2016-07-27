package exceptions;

/**
 * Created by Lorenz on 27/07/2016.
 */
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException (){
        super("Not enough money");
    }
}
