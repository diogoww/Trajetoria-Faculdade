package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;

public class Apartamento extends Financiamento {

    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
    }

    @Override
    public double calcPagamentoMensal() {
        double taxaMensal = this.taxaJurosAnual / 12;
        int meses = this.prazoFinanciamento * 12;

        if (taxaMensal == 0) {
            return this.valorImovel / meses;
        }

        double numerador = this.valorImovel * taxaMensal * Math.pow((1 + taxaMensal), meses);
        double denominador = Math.pow((1 + taxaMensal), meses) - 1;

        return numerador / denominador;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DETALHES DO FINANCIAMENTO DE APARTAMENTO ---");
        super.exibirDados();
    }
}