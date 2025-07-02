package FinanciamentoImobiliarios.modelo;

import FinanciamentoImobiliarios.excecoes.AumentoMaiorDoQueJurosException;
import java.io.Serializable;

public class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double valorImovel;
    protected double taxaJurosAnual;
    protected int prazoFinanciamento;

    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    protected double calcPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        int meses = prazoFinanciamento * 12;
        double taxaMensal = taxaJurosAnual / 12;
        double pagamentoMensal = (valorImovel / meses) * (1 + taxaMensal);
        return pagamentoMensal;
    }

    public double calcPagamentoTotal() throws AumentoMaiorDoQueJurosException {
        double pagamentoMensal = calcPagamentoMensal();
        int meses = prazoFinanciamento * 12;
        return pagamentoMensal * meses;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void exibirDados() {
        System.out.println(" -- detalhes do financiamento --");
        System.out.printf("valor do imovel: R$ %.2f%n", getValorImovel());
        System.out.printf("prazo do financiamento: %d anos%n ", getPrazoFinanciamento());
        System.out.printf("taxas de juros anual: %.2f%%%n", getTaxaJurosAnual() * 100);
        try {
            System.out.printf("pagamento mensal estimado: R$ %.2f%n", calcPagamentoMensal());
            System.out.printf("valor total do financiamento: R$ %.2f%n", calcPagamentoTotal());
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("N/A (Erro no cálculo da parcela: " + e.getMessage() + ")");
        }
        System.out.println("-------------");
    }
}
