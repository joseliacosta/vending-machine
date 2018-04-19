import org.junit.Assert;
import org.junit.Test;
import product.Product;
import product.ProductUnit;
import repositories.CoinRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachineTest {

    @Test
    public void getProducts_shouldReturnThreeProducts() {
        List<Product> products = new ArrayList<>();
        Product productUnit1 = new ProductUnit("Dadinho", 0.15);
        Product productUnit2 = new ProductUnit("Suco", 2.00);
        Product productUnit3 = new ProductUnit("Amendoim", 1.15);
        products.add(productUnit1);
        products.add(productUnit2);
        products.add(productUnit3);
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        VendingMachine machine = new VendingMachine(products, coinRepository);
        Assert.assertEquals(3, machine.getProducts().size());
    }
    @Test
    public void shouldCalculateChange() throws InvalidPaymentException {
        VendingMachine machine = new VendingMachine();
        Assert.assertEquals(5, machine.calculateChange(5,10), 0);
    }

    @Test(expected = InvalidPaymentException.class)
    public void shouldThrowAnExeptionIfPaymentIsLessThanProductPrice() throws InvalidPaymentException {
        VendingMachine machine = new VendingMachine();
        machine.calculateChange(10,5);
    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIsTwo() {
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        coinRepository.add(0.50,10);
        coinRepository.add(0.25,10);
        coinRepository.add(0.10,10);
        VendingMachine machine = new VendingMachine(coinRepository);
        Map result = machine.calculateCoins(2.00);
        Assert.assertEquals(2, result.get(1.00));
    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIs375() {
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        coinRepository.add(0.50,10);
        coinRepository.add(0.25,10);
        coinRepository.add(0.10,10);

        VendingMachine machine = new VendingMachine(coinRepository);
        Map result = machine.calculateCoins(3.75);

        Assert.assertEquals(3, result.get(1.00));
        Assert.assertEquals(1, result.get(0.5));
        Assert.assertEquals(1, result.get(0.25));
        Assert.assertEquals(null, result.get(0.1));
        Assert.assertEquals(null, result.get(0.05));
        Assert.assertEquals(null, result.get(0.01));

    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIs325() {

        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        coinRepository.add(0.25,10);

        VendingMachine machine = new VendingMachine(coinRepository);
        Map result = machine.calculateCoins(3.25);

        Assert.assertEquals(3, result.get(1.00));
        Assert.assertEquals(null, result.get(0.5));
        Assert.assertEquals(1, result.get(0.25));
        Assert.assertEquals(null, result.get(0.1));
        Assert.assertEquals(null, result.get(0.05));
        Assert.assertEquals(null, result.get(0.01));

    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIs1525AndQtdCoinsIsLimited() {
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        coinRepository.add(0.50,10);
        coinRepository.add(0.25,1);

        VendingMachine machine = new VendingMachine(coinRepository);
        Map result = machine.calculateCoins(15.25);

        Assert.assertEquals(10, result.get(1.00));
        Assert.assertEquals(10, result.get(0.5));
        Assert.assertEquals(1, result.get(0.25));
        Assert.assertEquals(null, result.get(0.1));
        Assert.assertEquals(null, result.get(0.05));
        Assert.assertEquals(null, result.get(0.01));

    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIs1800AndQtdCoinsIsLimited() {
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        coinRepository.add(0.50,15);
        coinRepository.add(0.25,2);

        VendingMachine machine = new VendingMachine(coinRepository);
        Map result = machine.calculateCoins(18.00);

        Assert.assertEquals(10, result.get(1.00));
        Assert.assertEquals(15, result.get(0.5));
        Assert.assertEquals(2, result.get(0.25));
        Assert.assertEquals(null, result.get(0.1));
        Assert.assertEquals(null, result.get(0.05));
        Assert.assertEquals(null, result.get(0.01));

    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIs1900AndQtdCoinsIsLimited() {
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        coinRepository.add(0.50,15);
        coinRepository.add(0.25,6);

        VendingMachine machine = new VendingMachine(coinRepository);
        Map result = machine.calculateCoins(19.00);

        Assert.assertEquals(10, result.get(1.00));
        Assert.assertEquals(15, result.get(0.5));
        Assert.assertEquals(6, result.get(0.25));
        Assert.assertEquals(null, result.get(0.1));
        Assert.assertEquals(null, result.get(0.05));
        Assert.assertEquals(null, result.get(0.01));

    }
}