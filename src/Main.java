import product.Product;
import repositories.CoinRepository;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("Dadinho", 0.15);
        Product product2 = new Product("Suco", 2.00);
        Product product3 = new Product("Amendoim", 1.15);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,10);
        VendingMachine machine = new VendingMachine(products, coinRepository);


        for(Product product : machine.getProducts()) {
            System.out.println(product.getName());
        }

        System.out.println("Informe o número do produto escolhido: ");
        Scanner scanner = new Scanner(System.in);
        double productPrice = scanner.nextDouble();

        double payment = scanner.nextDouble();

        try {
            double change = machine.calculateChange(productPrice, payment);
            System.out.println("Por favor, retire o seu troco no valor de: R$" + change);
            Map changeCoins = machine.calculateCoins(change);
            changeCoins.forEach((coin, qtde ) -> {
                    System.out.println(qtde + " moeda(s) de "+ coin);
            });

        } catch (InvalidPaymentException e) {
            System.out.println("Olha o golpe! Fora Temer.");
        }
    }
}
