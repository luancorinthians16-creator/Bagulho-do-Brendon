import java.util.Scanner;

public class MaiorValorArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[5];

        // Leitura dos valores
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "º valor: ");
            numeros[i] = scanner.nextInt();
        }

        // Considera o primeiro valor como o maior inicialmente
        int maior = numeros[0];

        // Percorre o array procurando o maior valor
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }

        System.out.println("O maior valor informado foi: " + maior);

        scanner.close();
    }
}