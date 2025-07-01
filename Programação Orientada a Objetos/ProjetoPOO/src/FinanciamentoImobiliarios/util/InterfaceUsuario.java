package FinanciamentoImobiliarios.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario(){
        this.scanner = new Scanner(System.in);
    }

    public double valorImovel(){
        double valor;
        boolean entradaValida = false;
        do {
            System.out.print("digite o valor do imovel: ");
            try { // <-- Adicionando try/catch para valorImovel() também
                valor = scanner.nextDouble();
                if (valor > 0){
                    entradaValida = true;
                    System.out.println("o valor eh: " + valor);
                } else {
                    System.out.println("ERRO: o valor do imovel deve ser válido. (positivo).");
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERRO: entrada inválida. digite um número para o valor do imóvel.");
                scanner.next();
                valor = -1;
            }
        } while (!entradaValida);
        return valor;
    }

    public int prazoFinanciamento() {
        int prazo;
        boolean entradaValida = false;
        do {
            System.out.print("digite o prazo do financiamento (em anos): ");
            try {
                prazo = scanner.nextInt();
                if (prazo > 0){
                    entradaValida = true;
                    System.out.println("o prazo eh de: " + prazo + " anos");
                } else {
                    System.out.println("ERRO: o prazo precisa ser um ano válido. (positivo)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("ERRO: entrada inválida. digite um numero inteiro p/ o prazo.");
                scanner.next();
                prazo = -1;
            }
        } while (!entradaValida);
        return prazo;
    }

    public double taxaJuros() {
        double taxas;
        boolean entradaValida = false;
        do {
            System.out.print("digite a taxa de juros anual: ");
            try {
                taxas = scanner.nextDouble();
                if (taxas > 0) {
                    entradaValida = true;
                    System.out.println("a taxa de juros eh: " + taxas);
                } else {
                    System.out.println("ERRO: a taxa de juros deve ser positiva.");
                }
            } catch (InputMismatchException ex){
                System.out.println("ERRO: entrada inválida. digite um numero p/ a taxa de juros.");
                scanner.next();
                taxas = -1.0;
            }
        } while (!entradaValida);
        return taxas;
    }

    public void fecharScanner(){
        if (scanner != null){
            scanner.close();
        }
    }
}