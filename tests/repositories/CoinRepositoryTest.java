package repositories;

import static org.junit.Assert.*;
import org.junit.Test;


public class CoinRepositoryTest {
    @Test
    public void add_shouldAddCoinsToStorage() {
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 10);
        assertEquals(10, repository.getQuantity(1.00));
    }

    @Test
    public void add_shouldIncrementCoins_whenCoinAlreadyExist() {
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 10);
        repository.add(1.00, 15);
        assertEquals(25, repository.getQuantity(1.00));
    }

    @Test
    public void getQuantity_shouldReturn0_whenCoinDoesntExist() {
        CoinRepository repository = new CoinRepository();
        assertEquals(0, repository.getQuantity(1.00));
    }

    @Test
    public void withdraw_shouldDecrementQuantityFromStorage() throws repositories.InvalidQuantityCoinsException{
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 100);
        repository.withdraw(1.00,10);
        assertEquals(90, repository.getQuantity(1.00));
    }

    @Test
    public void getCoins_shouldReturnAvailableCoins() {

        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 10);
        repository.add(0.50, 5);
        repository.add(0.25, 15);

        assertEquals(3, repository.getCoins().size());
        assertEquals(true,repository.getCoins().contains(1.00));
        assertEquals(true,repository.getCoins().contains(0.50));
        assertEquals(true,repository.getCoins().contains(0.25));

    }

    @Test
    public void getCoins_shouldIgnoreCoins_whenQuantityIsZero() {

        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 0);
        repository.add(0.50, 0);
        repository.add(0.25, 0);
        repository.add(0.10, 10);

        assertEquals(1, repository.getCoins().size());
        assertEquals(true, repository.getCoins().contains(0.10));

    }

    @Test(expected = repositories.InvalidQuantityCoinsException.class)
    public void withdraw_shouldThrowAnException_ifCoinQuantityIsLessThanZero() throws repositories.InvalidQuantityCoinsException {
        CoinRepository repository = new CoinRepository();
        repository.add(1.00, 1);
        repository.withdraw(1.00,2);

    }
}