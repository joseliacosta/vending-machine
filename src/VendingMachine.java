import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    public double coins[] = {1.00, 0.50, 0.25, 0.10, 0.05, 0.01};

    public int limit[] = {10,15,20,25,30,35};

    public double calculateChange(double productPrice, double payment) throws InvalidPaymentException {
        if(payment < productPrice) {
            throw new InvalidPaymentException();
        }
        return payment - productPrice;
    }

    public Map <Double,Integer> calculateCoins(double change) {

        Map qtdeCoins = new HashMap<Double, Integer>();

        double changeRest = change;
        int quantity = 0;

        for(int counter = 0; counter < coins.length; counter++) {
            quantity = (int)(changeRest / coins[counter]);

            if(quantity > 10) {
                quantity = 10;
            }

            changeRest = changeRest - (quantity * coins[counter]);

            if(quantity != 0) {
                qtdeCoins.put(coins[counter], quantity);
            }

            if(changeRest == 0) {
                break;
            }
        }
        return qtdeCoins;

    }
}



