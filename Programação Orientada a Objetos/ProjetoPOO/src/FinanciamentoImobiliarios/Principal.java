package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Digite os dados para um financiamento de CASA ---");
        System.out.print("Valor do imóvel: R$ ");
        double valorImovelUser = scanner.nextDouble();
        System.out.print("Prazo do financiamento (em anos): ");
        int prazoAnosUser = scanner.nextInt();
        System.out.print("Taxa de juros anual (ex: 0.10 para 10%): ");
        double taxaJurosUser = scanner.nextDouble();

        Casa financiamentoUsuario = new Casa(valorImovelUser, taxaJurosUser, prazoAnosUser);
        financiamentos.add(financiamentoUsuario);

        financiamentos.add(new Casa(350000.0, 0.08, 20));
        financiamentos.add(new Casa(450000.0, 0.075, 25));

        financiamentos.add(new Apartamento(280000.0, 0.09, 15));
        financiamentos.add(new Apartamento(220000.0, 0.08, 10));

        financiamentos.add(new Terreno(120000.0, 0.11, 8));

        double somaValoresImoveis = 0;
        double somaValoresFinanciamentos = 0;

        System.out.println("\n--- TODOS OS FINANCIAMENTOS ---");
        for (Financiamento f : financiamentos) {
            f.exibirDados(); // Chamada polimórfica
            somaValoresImoveis += f.getValorImovel();
            somaValoresFinanciamentos += f.calcPagamentoTotal();
        }

        System.out.printf("\nSoma total dos valores dos imóveis: R$ %.2f%n", somaValoresImoveis);
        System.out.printf("Soma total dos valores dos financiamentos (com juros e taxas): R$ %.2f%n", somaValoresFinanciamentos);

        scanner.close();
    }
}