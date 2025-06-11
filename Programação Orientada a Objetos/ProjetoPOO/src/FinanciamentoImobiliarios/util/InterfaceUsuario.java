package FinanciamentoImobiliarios.util;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario(){
        this.scanner = new Scanner(System.in);
    }

    public double valorImovel(){
        System.out.print("digite o valor do imovel: ");
        double valor = scanner.nextDouble();
        System.out.println("o valor eh: " + valor);
        return valor;
    }

    public int prazoFinanciamento() {
        System.out.print("digite o prazo do financiamento (em anos): ");
        int prazo = scanner.nextInt();
        System.out.println("o prazo eh de: " + prazo + " anos");
        return prazo;
    }

    public double taxaJuros() {
        System.out.print("digite a taxa de juros anual: ");
        double taxas = scanner.nextDouble();
        System.out.println("a taxa de juros eh: " + taxas);
        return taxas;
    }

    public void fecharScanner(){
        if (scanner != null){
            scanner.close();
        }
    }

}