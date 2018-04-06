package repositories;


import java.util.*;

public class CoinRepository {
    private Map<Double,Integer> coins;

    public CoinRepository(){
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

    //TODO getCoins that return coins


    public List<Double> getCoins() {
        Set<Double> coinsValues = coins.keySet();

        List<Double> coins = new ArrayList<>();

        for (Double coin: coinsValues) {
            if(getQuantity(coin) != 0) {
                coins.add(coin);
            }
        }

        return coins;
    }

    public void withdraw(double coin, Integer quantity) throws InvalidQuantityCoinsException{
        Integer currentQuantity = getQuantity(coin);
        Integer total = currentQuantity - quantity;
        if(total < 0){
            throw new InvalidQuantityCoinsException();
        }
        coins.put(coin, total);
    }
}
