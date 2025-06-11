package FinanciamentoImobiliarios;

public class Financiamento {

    private double valorImovel;
    private double taxaJurosAnual;
    private int prazoFinanciamento;

    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public double calcPagamentoMensal(){
        int meses = prazoFinanciamento*12;
        double taxaMensal = taxaJurosAnual/12;
        double pagamentoMensal = (valorImovel/meses)*(1+taxaMensal);
        return pagamentoMensal;
    }

    public double calcPagamentoTotal(){
        double pagamentoMensal = calcPagamentoMensal();
        int meses = prazoFinanciamento*12;
        return pagamentoMensal*meses;
    }
}
