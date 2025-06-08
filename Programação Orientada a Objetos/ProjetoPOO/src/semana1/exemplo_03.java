package semana1;

public class exemplo_03 {
    public static void main(String[] args) {

        String nome = "Rafaela";
        int idade = 32;
        double altura = 1.65;


        System.out.println("Exemplo 1:");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Nome: " + nome + ", Altura: " + altura);


        System.out.print("\nExemplo 2:\n");
        System.out.print("Nome: " + nome + "\n");
        System.out.print("Idade: " + idade + "\n");
        System.out.print("Altura: " + altura + "\n");
        System.out.print("Nome: " + nome + ", Altura: " + altura + "\n");


        System.out.println("\nExemplo 3:");
        System.out.printf("Nome: %s\n", nome);
        System.out.printf("Idade: %d\n", idade);
        System.out.printf("Altura: %.2f\n", altura);
        System.out.printf("Nome: %s, Altura: %.2f\n", nome, altura);
        System.out.println();

        System.out.println("\nExemplo 4:");
        System.out.format("Nome: %s\n", nome);
        System.out.format("Idade: %d\n", idade);
        System.out.format("Altura: %.2f\n", altura);
        System.out.format("Nome: %s, Altura: %.2f\n", nome, altura);
        System.out.println();


        System.out.println("\nExemplo 5:");
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Nome: ").append(nome).append("\n");
        mensagem.append("Idade: ").append(idade).append("\n");
        mensagem.append("Altura: ").append(altura).append("\n");
        mensagem.append("Nome: ").append(nome).append(", Altura: ").append(altura).append("\n");
        System.out.println(mensagem);

    }
}
