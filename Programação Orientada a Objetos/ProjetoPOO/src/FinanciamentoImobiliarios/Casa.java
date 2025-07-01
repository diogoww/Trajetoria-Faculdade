package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;

public class Casa extends Financiamento {
    private static final double VALOR_SEGURO_FIXO = 80.0;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
    }

    @Override
    public double calcPagamentoMensal() {
        return super.calcPagamentoMensal() + VALOR_SEGURO_FIXO;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DETALHES DO FINANCIAMENTO DE CASA ---");
        super.exibirDados(); // Chama o método da classe pai para exibir os detalhes comuns
    }
}