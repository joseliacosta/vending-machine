package repositories;

import java.util.HashMap;
import java.util.Map;

public class CoinRepository {
    private Map<Double,Integer> coins;

    CoinRepository(){
        coins = new HashMap();
    }

    public void add(double coin, int quantity) {
        Integer currentQuantity = getQuantity(coin);
        Integer total = currentQuantity + quantity;
        coins.put(coin, total);
    }

    public Integer getQuantity(double coin) {
        if(coins.containsKey(coin)) {
            return coins.get(coin);
        }
        return 0;
    }

    public void withdraw(double coin, Integer quantity) {
        Integer currentQuantity = getQuantity(coin);
        Integer total = currentQuantity - quantity;
        coins.put(coin, total);
    }
}
