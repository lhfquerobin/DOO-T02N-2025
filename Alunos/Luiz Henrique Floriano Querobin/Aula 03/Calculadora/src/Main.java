import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<VendaHistorico> vendasHistorico = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    private static void menu() {
        System.out.println("""
                1 - Realizar Venda
                2 - Calcular Troco
                3 - Ver Histórico de Venda
                0 - Sair
                Digite sua escolha:\s""");
        var escolha = scanner.nextInt();
        escolha(escolha);
    }

    private static void escolha(int escolha) {
        switch (escolha) {
            case 1:
                realizarVenda();
                break;
            case 2:
                calculaTroco();
                break;
            case 3:
                verHistorico();
                break;
            case 0:
                System.exit(0);
        }
    }

    private static void verHistorico() {
        vendasHistorico.forEach(System.out::println);
    }

    private static void realizarVenda() {
        System.out.println("Digite a quantidade que será comprada: ");
        var quantidade = scanner.nextInt();
        System.out.println("Digite o preço:");
        var preco = scanner.nextDouble();
        var valorASerPago = quantidade * preco;
        var desconto = 0.0;
        if (quantidade > 10) {
            desconto = ((valorASerPago / 100) * 5);
            valorASerPago -= desconto;
        }
        System.out.println("O valor a ser pago é: R$" + valorASerPago);
        vendasHistorico.add(new VendaHistorico(quantidade, valorASerPago, desconto));
    }

    private static void calculaTroco() {
        System.out.println("Digite o valor recebido: ");
        var valorRecebido = scanner.nextDouble();
        System.out.println("Digite o valor total da compra: ");
        var valorTotal = scanner.nextDouble();
        System.out.println("O valor do troco é: R$" + (valorRecebido - valorTotal));
    }
}