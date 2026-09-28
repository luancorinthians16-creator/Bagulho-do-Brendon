import java.util.Scanner;

public class ControleEstoque {
    static final int TOTAL_PRODUTOS = 5;
    static final int LIMITE_ESTOQUE_BAIXO = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] produtos = new String[TOTAL_PRODUTOS];
        int[] quantidades = new int[TOTAL_PRODUTOS];

        cadastrarProdutos(scanner, produtos, quantidades);
        int total = calcularTotal(quantidades);
        exibirRelatorio(produtos, quantidades, total);
        scanner.close();
    }

    static void cadastrarProdutos(Scanner scanner, String[] produtos, int[] quantidades) {
        for (int i = 0; i < TOTAL_PRODUTOS; i++) {
            // Validação do nome
            String nome;
            do {
                System.out.print("Digite o nome do produto " + (i + 1) + ": ");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()) {
                    System.out.println("Nome invalido! Digite novamente.");
                }
            } while (nome.isEmpty());
            produtos[i] = nome;

            // Validação da quantidade
            int qtd;
            do {
                System.out.print("Digite a quantidade de " + nome + ": ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Quantidade invalida! Digite um numero.");
                    System.out.print("Digite a quantidade de " + nome + ": ");
                    scanner.next();
                }
                qtd = scanner.nextInt();
                scanner.nextLine(); // limpar o buffer
                if (qtd < 0) {
                    System.out.println("Quantidade nao pode ser negativa!");
                }
            } while (qtd < 0);
            quantidades[i] = qtd;
        }
    }

    static int calcularTotal(int[] quantidades) {
        int total = 0;
        // Percorra todos os elementos.
        for (int i = 0; i < quantidades.length; i++) {
            total += quantidades[i];
        }
        return total;
    }

    static void exibirRelatorio(String[] produtos, int[] quantidades, int total) {
        // Mostre o total e os produtos com menos de cinco unidades.
        System.out.println("\n--- RELATORIO DE ESTOQUE ---");
        System.out.println("Total de itens em estoque: " + total);
        System.out.println("\nProdutos com estoque baixo (menos de " + LIMITE_ESTOQUE_BAIXO + " unidades):");

        boolean temEstoqueBaixo = false;
        for (int i = 0; i < produtos.length; i++) {
            if (quantidades[i] < LIMITE_ESTOQUE_BAIXO) {
                System.out.println("- " + produtos[i] + ": " + quantidades[i] + " unidades");
                temEstoqueBaixo = true;
            }
        }

        if (!temEstoqueBaixo) {
            System.out.println("Nenhum produto com estoque baixo.");
        }
    }
}