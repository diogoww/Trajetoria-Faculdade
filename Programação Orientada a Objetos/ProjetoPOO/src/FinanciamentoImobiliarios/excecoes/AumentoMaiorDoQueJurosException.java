package FinanciamentoImobiliarios.excecoes;

public class AumentoMaiorDoQueJurosException extends RuntimeException {
    public AumentoMaiorDoQueJurosException() {
        super("O valor do acréscimo de R$ 80,00 é maior do que a metade do valor dos juros da mensalidade.");
    }

    public AumentoMaiorDoQueJurosException(String message) {
        super(message);
    }
}