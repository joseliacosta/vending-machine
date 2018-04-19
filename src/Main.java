import product.Product;
import product.ProductUnit;
import repositories.CoinRepository;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        List<Product> products = new ArrayList<>();
        Product productUnit1 = new ProductUnit("Dadinho", 0.15);
        Product productUnit2 = new ProductUnit("Suco", 2.10);
        Product productUnit3 = new ProductUnit("Amendoim", 2.15);
        Product productUnit4 = new ProductUnit("Paçoca", 0.50);
        Product productUnit5 = new ProductUnit("Pipoca", 1.00);
        Product productUnit6 = new ProductUnit("Bolacha", 5.00);
        products.add(productUnit1);
        products.add(productUnit2);
        products.add(productUnit3);
        products.add(productUnit4);
        products.add(productUnit5);
        products.add(productUnit6);
        CoinRepository coinRepository = new CoinRepository();
        coinRepository.add(1.00,20);
        coinRepository.add(0.50,40);
        coinRepository.add(0.25,50);
        coinRepository.add(0.10,10);
        VendingMachine machine = new VendingMachine(products, coinRepository);


        for(int counter = 0; counter < machine.getProducts().size(); counter++) {
            if(counter==0){
                System.out.println("Cód.    Produto     Preço \n");
            }
            System.out.println(
                            counter + 1 +  "   -    " +
                            machine.getProducts().get(counter).getName() + "   -   " +
                            machine.getProducts().get(counter).getPrice());
        }

        System.out.println("Informe o número do produto escolhido: ");
        Scanner scanner = new Scanner(System.in);
        int productChoosed = scanner.nextInt();

        double productPrice = machine.getProducts().get(productChoosed-1).getPrice();

        System.out.println("Por favor, efetue o pagamento: ");

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
