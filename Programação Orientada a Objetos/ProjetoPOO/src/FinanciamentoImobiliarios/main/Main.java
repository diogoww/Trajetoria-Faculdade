package FinanciamentoImobiliarios.main;

import FinanciamentoImobiliarios.modelo.Financiamento;
import FinanciamentoImobiliarios.Casa;
import FinanciamentoImobiliarios.Apartamento;
import FinanciamentoImobiliarios.Terreno;
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
                somaValoresImoveis += f.getValorImovel();
            }
        }

        System.out.printf("\nSoma total dos valores dos imóveis: R$ %.2f%n", somaValoresImoveis);
        System.out.printf("Soma total dos valores dos financiamentos (com juros e taxas): R$ %.2f%n", somaValoresFinanciamentos);

        interfaceUsuario.fecharScanner();
    }
}