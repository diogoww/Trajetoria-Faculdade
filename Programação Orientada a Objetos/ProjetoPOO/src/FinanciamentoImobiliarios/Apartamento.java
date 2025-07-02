package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.modelo.Financiamento;
import FinanciamentoImobiliarios.excecoes.AumentoMaiorDoQueJurosException;
import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numeroAndar;

    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, int numeroAndar) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.numeroAndar = numeroAndar;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public double calcPagamentoMensal() throws AumentoMaiorDoQueJurosException {
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
        System.out.printf("Número do Andar: %d%n", numeroAndar);
    }
}