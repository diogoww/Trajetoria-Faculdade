package FinanciamentoImobiliarios;

import FinanciamentoImobiliarios.excecoes.AumentoMaiorDoQueJurosException;
import FinanciamentoImobiliarios.modelo.Financiamento;
import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipoTerreno;

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, String tipoTerreno) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.tipoTerreno = tipoTerreno;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    @Override
    public double calcPagamentoMensal() {
        try {
            return super.calcPagamentoMensal() * 1.02;
        } catch (AumentoMaiorDoQueJurosException e) {
            throw e;
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- DETALHES DO FINANCIAMENTO DE TERRENO ---");
        super.exibirDados();
        System.out.printf("Tipo de Terreno: %s%n", tipoTerreno);
    }
}