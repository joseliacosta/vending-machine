import org.junit.Assert;
import org.junit.Test;
import product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void getProducts_shouldReturnThreeProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("Dadinho", 0.15);
        Product product2 = new Product("Suco", 2.00);
        Product product3 = new Product("Amendoim", 1.15);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        VendingMachine machine = new VendingMachine(products);
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
        VendingMachine machine = new VendingMachine();
        Map result = machine.calculateCoins(2.00);
        Assert.assertEquals(2, result.get(1.00));
    }

    @Test
    public void shouldCalculateCoinsQtdWhenChangeIs375() {
        VendingMachine machine = new VendingMachine();
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
        VendingMachine machine = new VendingMachine();
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
        VendingMachine machine = new VendingMachine();
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
        VendingMachine machine = new VendingMachine();
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
        VendingMachine machine = new VendingMachine();
        Map result = machine.calculateCoins(19.00);

        Assert.assertEquals(10, result.get(1.00));
        Assert.assertEquals(15, result.get(0.5));
        Assert.assertEquals(6, result.get(0.25));
        Assert.assertEquals(null, result.get(0.1));
        Assert.assertEquals(null, result.get(0.05));
        Assert.assertEquals(null, result.get(0.01));

    }
}