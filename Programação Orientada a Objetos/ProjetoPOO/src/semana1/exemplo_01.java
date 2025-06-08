package semana1;

import  java.util.Scanner;

public class exemplo_01 {

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite um numero: ");
        int num = scanner.nextInt();

        if (num > 0){
            System.out.println("o numero eh positivo");
        } else if (num < 0){
            System.out.println("o numero eh negativo");
        } else {
            System.out.println("o numero eh 0");
        }
    }
}