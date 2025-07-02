package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;
import FinanciamentoImobiliarios.util.GerenciadorArquivos;
import FinanciamentoImobiliarios.excecoes.AumentoMaiorDoQueJurosException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // --- Coleta de dados do usuário para um financiamento de CASA ---
        System.out.println("--- Digite os dados para um financiamento de CASA ---");
        System.out.print("Valor do imóvel: R$ ");
        double valorImovelUser = scanner.nextDouble();
        System.out.print("Prazo do financiamento (em anos): ");
        int prazoAnosUser = scanner.nextInt();
        System.out.print("Taxa de juros anual (ex: 0.10 para 10%): ");
        double taxaJurosUser = scanner.nextDouble();
        System.out.print("Área construída da casa (m²): ");
        double areaConstruidaUser = scanner.nextDouble();

        Casa financiamentoUsuario = new Casa(valorImovelUser, taxaJurosUser, prazoAnosUser, areaConstruidaUser);
        financiamentos.add(financiamentoUsuario);

        financiamentos.add(new Casa(350000.0, 0.08, 20, 150.0));
        financiamentos.add(new Casa(450000.0, 0.075, 25, 200.0));

        financiamentos.add(new Apartamento(280000.0, 0.09, 15, 5));
        financiamentos.add(new Apartamento(220000.0, 0.08, 10, 2));

        financiamentos.add(new Terreno(120000.0, 0.11, 8, "Urbano"));

        double somaValoresImoveis = 0;
        double somaValoresFinanciamentos = 0;

        System.out.println("\n--- TODOS OS FINANCIAMENTOS CRIADOS ---");
        for (Financiamento f : financiamentos) {
            try {
                f.exibirDados();
                somaValoresImoveis += f.getValorImovel();
                somaValoresFinanciamentos += f.calcPagamentoTotal();
            } catch (AumentoMaiorDoQueJurosException e) {
                System.err.println("ERRO (Financiamento de Casa): " + e.getMessage());
                System.out.printf("  Financiamento de: %s%n", f.getClass().getSimpleName());
                System.out.printf("  Valor do Imóvel: R$ %.2f%n", f.getValorImovel());
                System.out.printf("  Prazo: %d anos%n", f.getPrazoFinanciamento());
                System.out.printf("  Taxa de Juros: %.2f%%%n", f.getTaxaJurosAnual() * 100);
                System.out.println("  **Cálculo da parcela inviável devido a regras do banco.**");
                System.out.println("------------------------------------");
                somaValoresImoveis += f.getValorImovel();
            } catch (Exception e) {
                System.err.println("ERRO INESPERADO ao processar financiamento: " + e.getMessage());
                System.out.printf("  Financiamento de: %s%n", f.getClass().getSimpleName());
                System.out.printf("  Valor do Imóvel: R$ %.2f%n", f.getValorImovel());
                System.out.println("------------------------------------");
                somaValoresImoveis += f.getValorImovel();
            }
        }

        System.out.printf("\nSoma total dos valores dos imóveis: R$ %.2f%n", somaValoresImoveis);
        System.out.printf("Soma total dos valores dos financiamentos (com juros e taxas): R$ %.2f%n", somaValoresFinanciamentos);

        GerenciadorArquivos.gravarFinanciamentosTexto(financiamentos);

        System.out.println("\n--- Comprovando Leitura de Arquivo de Texto ---");
        ArrayList<Financiamento> financiamentosLidosTexto = GerenciadorArquivos.lerFinanciamentosTexto();
        double somaValoresImoveisLidosTexto = 0;
        double somaValoresFinanciamentosLidosTexto = 0;

        for (Financiamento f : financiamentosLidosTexto) {
            try {
                f.exibirDados();
                somaValoresImoveisLidosTexto += f.getValorImovel();
                somaValoresFinanciamentosLidosTexto += f.calcPagamentoTotal();
            } catch (AumentoMaiorDoQueJurosException e) {
                System.err.println("ERRO (Financiamento de Casa - Lido do Texto): " + e.getMessage());
                System.out.printf("  Financiamento de: %s%n", f.getClass().getSimpleName());
                System.out.printf("  Valor do Imóvel: R$ %.2f%n", f.getValorImovel());
                System.out.println("  **Cálculo da parcela inviável devido a regras do banco.**");
                System.out.println("------------------------------------");
                somaValoresImoveisLidosTexto += f.getValorImovel();
            } catch (Exception e) {
                System.err.println("ERRO INESPERADO ao processar financiamento lido do texto: " + e.getMessage());
                somaValoresImoveisLidosTexto += f.getValorImovel();
            }
        }
        System.out.printf("\nSoma total dos valores dos imóveis LIDOS (Texto): R$ %.2f%n", somaValoresImoveisLidosTexto);
        System.out.printf("Soma total dos valores dos financiamentos LIDOS (Texto): R$ %.2f%n", somaValoresFinanciamentosLidosTexto);

        GerenciadorArquivos.serializarFinanciamentos(financiamentos);

        System.out.println("\n--- Comprovando Leitura de Financiamentos Serializados ---");
        ArrayList<Financiamento> financiamentosLidosSerializados = GerenciadorArquivos.deserializarFinanciamentos();
        double somaValoresImoveisSerializados = 0;
        double somaValoresFinanciamentosSerializados = 0;

        for (Financiamento f : financiamentosLidosSerializados) {
            try {
                f.exibirDados();
                somaValoresImoveisSerializados += f.getValorImovel();
                somaValoresFinanciamentosSerializados += f.calcPagamentoTotal();
            } catch (AumentoMaiorDoQueJurosException e) {
                System.err.println("ERRO (Financiamento de Casa - Serializado): " + e.getMessage());
                System.out.printf("  Financiamento de: %s%n", f.getClass().getSimpleName());
                System.out.printf("  Valor do Imóvel: R$ %.2f%n", f.getValorImovel());
                System.out.println("  **Cálculo da parcela inviável devido a regras do banco.**");
                System.out.println("------------------------------------");
                somaValoresImoveisSerializados += f.getValorImovel();
            } catch (Exception e) {
                System.err.println("ERRO INESPERADO ao processar financiamento serializado: " + e.getMessage());
                somaValoresImoveisSerializados += f.getValorImovel();
            }
        }
        System.out.printf("\nSoma total dos valores dos imóveis SERIALIZADOS: R$ %.2f%n", somaValoresImoveisSerializados);
        System.out.printf("Soma total dos valores dos financiamentos SERIALIZADOS: R$ %.2f%n", somaValoresFinanciamentosSerializados);

        scanner.close();
    }
}