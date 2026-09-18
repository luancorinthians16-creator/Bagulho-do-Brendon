import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cont = 0;
        int conta = 0;

        while (true) {
            System.out.print("Qual a sua idade? ");
            int idade = scanner.nextInt();

            if (idade == 0) {
                break;
            }

            if (idade >= 18) {
                cont++;
            } else {
                conta++;
            }

            System.out.println("----------------------");
        }

        System.out.println("Pessoas maiores de idade: " + cont);
        System.out.println("Pessoas menores de idade: " + conta);

        scanner.close();
    }
}