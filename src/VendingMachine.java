import java.util.HashMap;
import java.util.List;
import java.util.Map;

import product.Product;
import product.ProductUnit;
import repositories.CoinRepository;

public class VendingMachine {

    private List<Product> products;
    private CoinRepository repository;
    public List<Double> coins;

    public VendingMachine() {
    }

    public VendingMachine(CoinRepository repository) {
        this.repository = repository;
        this.coins = this.repository.getCoins();
    }

    public VendingMachine(List<Product> products, CoinRepository repository) {
        this.products = products;
        this.repository = repository;
        this.coins = this.repository.getCoins();
    }


    public List<Product> getProducts() {
        return this.products;
    }


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

        for(int counter = 0; counter < coins.size(); counter++) {
            quantity = (int)(changeRest / coins.get(counter));

            if(quantity > repository.getQuantity(coins.get(counter))) {
                quantity = repository.getQuantity(coins.get(counter));
            }

            changeRest = changeRest - (quantity * coins.get(counter));

            if(quantity != 0) {
                qtdeCoins.put(coins.get(counter), quantity);
            }

            if(changeRest == 0) {
                break;
            }
        }
        return qtdeCoins;

    }
}



