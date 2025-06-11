package FinanciamentoImobiliarios;

import java.util.Scanner;

public class InterfaceUsuario {

    Scanner scanner = new Scanner(System.in);

    public void valorImovel(){
        System.out.print("digite o valor do imovel: ");
        double valorImovel = scanner.nextDouble();
        System.out.println("o valor eh: " + valorImovel);
    }

    public void prazoFinanciamento() {
        System.out.print("digite o prazo do financiamento (em anos): ");
        int prazo = scanner.nextInt();
        System.out.println("o prazo eh de: " + prazo + " anos");
    }

    public void taxaJuros() {
        System.out.print("digite a taxa de juros anual: ");
        double taxas = scanner.nextDouble();
        System.out.println("a taxa de juros eh: " + taxas);
    }

}