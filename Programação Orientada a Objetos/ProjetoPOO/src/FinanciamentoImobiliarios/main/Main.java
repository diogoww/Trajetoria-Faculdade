package FinanciamentoImobiliarios.main;

import FinanciamentoImobiliarios.modelo.Financiamento;
import FinanciamentoImobiliarios.Casa; // Assegure-se de que Casa tenha o construtor atualizado
import FinanciamentoImobiliarios.Apartamento;
import FinanciamentoImobiliarios.Terreno;
import FinanciamentoImobiliarios.util.GerenciadorArquivos;
import FinanciamentoImobiliarios.util.InterfaceUsuario;
import FinanciamentoImobiliarios.excecoes.AumentoMaiorDoQueJurosException;

import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("--- Digite os dados para um financiamento de CASA ---");
        double valorImovelUser = interfaceUsuario.valorImovel();
        int prazoAnosUser = interfaceUsuario.prazoFinanciamento();
        double taxaJurosUser = interfaceUsuario.taxaJuros();
        System.out.print("Área construída da casa (m²): ");
        double areaConstruidaUser = interfaceUsuario.scanner.nextDouble();
        System.out.println("--- Digite os dados para um financiamento de CASA ---");

        Casa financiamentoUsuario = new Casa(valorImovelUser, taxaJurosUser, prazoAnosUser, areaConstruidaUser);
        financiamentos.add(financiamentoUsuario);

        financiamentos.add(new Casa(350000.0, 0.08, 20, 150.0));
        financiamentos.add(new Casa(450000.0, 0.075, 25, 200.0));

        financiamentos.add(new Apartamento(280000.0, 0.09, 15, 5));
        financiamentos.add(new Apartamento(220000.0, 0.08, 10, 2));

        financiamentos.add(new Terreno(120000.0, 0.11, 8, "Urbano"));

        double somaValoresImoveis = 0;
        double somaValoresFinanciamentos = 0;

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

        interfaceUsuario.fecharScanner();
    }
}