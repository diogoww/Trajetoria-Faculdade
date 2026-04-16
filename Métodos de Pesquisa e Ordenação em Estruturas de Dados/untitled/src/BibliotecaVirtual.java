import java.util.LinkedList;

public class BibliotecaVirtual {

    public static void main(String[] args) {

        LinkedList<Livro> biblioteca = new LinkedList<>();

        biblioteca.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866));
        biblioteca.add(new Livro("Os Irmãos Karamazov", "Fiódor Dostoiévski", 1880));
        biblioteca.add(new Livro("Noites Brancas", "Fiódor Dostoiévski", 1848));
        biblioteca.add(new Livro("Notas do Subterrâneo", "Fiódor Dostoiévski", 1864));

        System.out.println("=== Biblioteca Virtual ===");

        for (Livro livro : biblioteca) {
            System.out.println(livro);
        }
    }
}
