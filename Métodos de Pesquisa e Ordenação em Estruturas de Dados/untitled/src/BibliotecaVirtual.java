import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BibliotecaVirtual {

    public static void main(String[] args) {

        //lista encadeada dos livros
        LinkedList<Livro> biblioteca = new LinkedList<>();

        biblioteca.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866));
        biblioteca.add(new Livro("Os Irmãos Karamazov", "Fiódor Dostoiévski", 1880));
        biblioteca.add(new Livro("Noites Brancas", "Fiódor Dostoiévski", 1848));
        biblioteca.add(new Livro("Notas do Subterrâneo", "Fiódor Dostoiévski", 1864));

        System.out.println("--- Biblioteca Virtual ---");

        for (Livro livro : biblioteca) {
            System.out.println(livro);
        }

        //fila de espera
        Queue<String> filaEspera = new LinkedList<>();

        filaEspera.add("Diogo Varaschin");
        filaEspera.add("Ana Clara");
        filaEspera.add("Elisiane Varaschin");
        filaEspera.add("Nosor de Oliveira");

        System.out.println("\n--- Fila de Espera ---");
        System.out.println("Próximo usuário da fila: " + filaEspera.peek());

        String atendido = filaEspera.poll();
        System.out.println("Usuário atendido: " + atendido);
        System.out.println("Próximo usuário da fila: " + filaEspera.peek());

        // pilha de historico
        Stack<String> historico = new Stack<>();
        historico.push("Crime e Castigo");
        historico.push("Os Irmãos Karamazov");
        historico.push("Noites Brancas");
        historico.push("Notas do Subterrâneo");

        System.out.println("\n--- Histórico de Navegação ---");
        System.out.println("Ultimo livro visualizado: " + historico.peek());

        System.out.println("Histórico completo: ");
        while(!historico.isEmpty()){
            System.out.println(historico.pop());
        }
    }
}
