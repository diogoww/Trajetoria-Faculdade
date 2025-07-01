package FinanciamentoImobiliarios.modelo;

public class Financiamento {

    protected double valorImovel;
    protected double taxaJurosAnual;
    protected int prazoFinanciamento;

    public Financiamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento) {
        this.valorImovel = valorImovel;
        this.taxaJurosAnual = taxaJurosAnual;
        this.prazoFinanciamento = prazoFinanciamento;
    }

    protected double calcPagamentoMensal(){
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

    public double getValorImovel() {
        return valorImovel;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void exibirDados(){
        System.out.println("\n -- detalhes do financiamento --");
        System.out.printf("valor do imovel: R$ %.2f%n", getValorImovel());
        System.out.printf("prazo do financiamento: %d anos%n ", getPrazoFinanciamento());
        System.out.printf("taxas de juros anual: R$ %.2f%%%n", getTaxaJurosAnual());
        System.out.printf("pagamento mensal estimado: R4 %.2f%n", calcPagamentoMensal());
        System.out.printf("valor total do financiamento: R$ %.2f%n", calcPagamentoTotal());
        System.out.println("-------------");
    }

}
