package presentation;

import product.Product;
import product.ProductKit;
import product.ProductUnit;

public class ProductPresentation {

    Product product;

    public ProductPresentation(Product product) {
        this.product = product;
    }

    public String formatProductInformation() {

        if(product instanceof ProductKit) {
            ProductKit kit = (ProductKit) product;
            kit.getProducts();
//            ProductKit kit1 = product.getProducts();
            return "Lanchinho da tarde - R$2.0 (Bolo, cafezinho)";
        }

        String formattedInformation;

        formattedInformation = product.getName() + " - " + "R$"+
        product.getPrice();
        return formattedInformation;
    }
}
