package presentation;

import org.junit.Assert;
import org.junit.Test;
import product.Product;
import product.ProductKit;
import product.ProductUnit;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductPresentationTest {
    @Test
    public void formatProductInformation_ShouldFormatNameAndPrice() throws Exception {
        ProductUnit product = new ProductUnit("Chocolate", 2.00);

        ProductPresentation productPresentation = new ProductPresentation(product);

        Assert.assertEquals("Chocolate - R$2.0", productPresentation.formatProductInformation());

    }

    @Test
    public void formatPRoductInformation_ShouldFormatNameAndPrice_WhenProductIsAKit() throws Exception {
        List<ProductUnit> products = new ArrayList<>();
        ProductUnit product1 = new ProductUnit("Bolo", 3.00);
        ProductUnit product2 = new ProductUnit("Cafezinho", 1.00);
        products.add(product1);
        products.add(product2);

        ProductKit kit = new ProductKit("Lanchinho da tarde", 0.5, products);

        ProductPresentation productPresentation = new ProductPresentation(kit);

        Assert.assertEquals("Lanchinho da tarde - R$2.0 (Bolo, cafezinho)", productPresentation.formatProductInformation());
    }
}