package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;
import FinanciamentoImobiliarios.excecoes.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private static final double VALOR_SEGURO_FIXO = 80.0;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
    }

    @Override
    protected double calcPagamentoMensal() {
        double taxaMensal = this.taxaJurosAnual / 12;
        double jurosDaMensalidadeBase = this.valorImovel * taxaMensal;

        if (VALOR_SEGURO_FIXO > (jurosDaMensalidadeBase / 2.0)) {
            throw new AumentoMaiorDoQueJurosException();
        }

        double parcelaBaseComJuros = super.calcPagamentoMensal();
        return parcelaBaseComJuros + VALOR_SEGURO_FIXO;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DETALHES DO FINANCIAMENTO DE CASA ---");
        super.exibirDados();
    }
}