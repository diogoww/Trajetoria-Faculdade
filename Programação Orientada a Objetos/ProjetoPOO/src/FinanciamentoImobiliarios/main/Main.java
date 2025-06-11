package FinanciamentoImobiliarios.main;

import FinanciamentoImobiliarios.util.InterfaceUsuario;

public class Main {

    public static void main(String [] args){

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        int prazoDigitado = interfaceUsuario.prazoFinanciamento();
        double valorImovelDigitado = interfaceUsuario.valorImovel();
        double taxaDigitada = interfaceUsuario.taxaJuros();

        interfaceUsuario.fecharScanner();
    }
}
