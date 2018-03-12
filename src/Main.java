import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) {
        System.out.println("Informe o valor do produto escolhido: ");
        Scanner scanner = new Scanner(System.in);
        double productPrice = scanner.nextDouble();
        System.out.println("Insira o dinheiro: ");
        double payment = scanner.nextDouble();

        VendingMachine machine = new VendingMachine();

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
