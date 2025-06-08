package semana1;

import java.util.Scanner;

public class exemplo_05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();

        if (idade > 0 && idade < 18) {
            System.out.println("Você é menor de idade.");
        } else if (idade < 0){
            System.out.println("digite uma idade valida");
        } else if (idade >= 18 && idade < 60) {
            System.out.println("Você é adulto.");
        } else {
            System.out.println("Você é um(a) idoso(a).");
        }

        scanner.close();
    }
}
