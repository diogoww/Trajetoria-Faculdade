package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;

public class Terreno extends Financiamento {

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
    }

    @Override
    public double calcPagamentoMensal() {
        return super.calcPagamentoMensal() * 1.02;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DETALHES DO FINANCIAMENTO DE TERRENO ---");
        super.exibirDados();
    }
}