package product;

import java.util.List;

public class ProductKit implements Product{

    private String name;
    private Double discount;
    private List<ProductUnit> products;

    public ProductKit( String name,
                       Double discount,
                       List<ProductUnit> products) {
        this.name = name;
        this.discount = discount;
        this.products = products;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public List<ProductUnit> getProducts() {
        return null;
    }
}
