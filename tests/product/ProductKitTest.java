package product;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductKitTest {
    //implementar o construtor OK
    //criar os testes para criar o kit OK
    //adicionar o kit na vending machine
    //remover o construtor vazio e o que recebe somente OK
    //o repositorio (arrumar todos os testes) OK


    @Test
    public void getPrice_shouldReturnKitPrice() {
        List<ProductUnit> products = new ArrayList<>();

        ProductUnit product1 = new ProductUnit("Dadinho", 0.50);
        ProductUnit product2 = new ProductUnit("Paçoca", 1.00);
        ProductUnit product3 = new ProductUnit("Pipoca", 1.00);
        products.add(product1);
        products.add(product2);
        products.add(product3);

        ProductKit kit1 = new ProductKit("Kit", 0.10, products);
        Assert.assertEquals(2.25, kit1.getPrice());

    }

    @Test
    public void getName_shouldReturnKitName() {
        List<ProductUnit> products = new ArrayList<>();

        ProductUnit product1 = new ProductUnit("Dadinho", 0.50);
        ProductUnit product2 = new ProductUnit("Paçoca", 1.00);
        ProductUnit product3 = new ProductUnit("Pipoca", 1.00);
        products.add(product1);
        products.add(product2);
        products.add(product3);

        ProductKit kit = new ProductKit("Kit Junino", 0.10, products);
        Assert.assertEquals("Kit Junino", kit.getName());

    }

    @Test
    public void getProducts_shouldReturnProductsInsideKit() {
        List<ProductUnit> products = new ArrayList<>();

        ProductUnit product1 = new ProductUnit("Dadinho", 0.50);
        ProductUnit product2 = new ProductUnit("Paçoca", 1.00);
        ProductUnit product3 = new ProductUnit("Pipoca", 1.00);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        ProductKit kit = new ProductKit("Kit Junino", 0.10, products);

        Assert.assertEquals(3, kit.getProducts().size());
        Assert.assertEquals(true, kit.getProducts().contains(product1));
        Assert.assertEquals(true, kit.getProducts().contains(product2));
        Assert.assertEquals(true, kit.getProducts().contains(product3));

    }
}