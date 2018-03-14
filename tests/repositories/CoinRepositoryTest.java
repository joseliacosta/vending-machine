package repositories;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinRepositoryTest {
    @Test
    public void add_shouldAddCoinsToStorage() {
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 10);
        Assert.assertEquals(10, repository.getQuantity(1.00));
    }

    @Test
    public void add_shouldIncrementCoins_whenCoinAlreadyExist() {
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 10);
        repository.add(1.00, 15);
        Assert.assertEquals(25, repository.getQuantity(1.00));
    }

    @Test
    public void getQuantity_shouldReturn0_whenCoinDoesntExist() {
        CoinRepository repository = new CoinRepository();
        Assert.assertEquals(0, repository.getQuantity(1.00));
    }

    @Test
    public void withdraw_shouldDecrementQuantityFromStorage() {
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 100);
        repository.withdraw(1.00,10);
        Assert.assertEquals(90, repository.getQuantity(1.00));
    }
}