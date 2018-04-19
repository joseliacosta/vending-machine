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
        Double productsValue = 0.00;

        for(int counter = 0; counter < products.size(); counter++) {
            productsValue += products.get(counter).getPrice();
        }

        return productsValue * (1 - discount);
    }

    @Override
    public String getName() {
         return name;
    }

    public List<ProductUnit> getProducts() {
        return null;
    }
}
