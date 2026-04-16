public class Main {

    public static void main(String[] args){

        ArvoreBiblioteca arvore = new ArvoreBiblioteca();

        arvore.inserir(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866));
        arvore.inserir(new Livro("Os Irmãos Karamazov", "Fiódor Dostoiévski", 1880));
        arvore.inserir(new Livro("Noites Brancas", "Fiódor Dostoiévski", 1848));
        arvore.inserir(new Livro("Notas do Subterrâneo", "Fiódor Dostoiévski", 1864));
        arvore.inserir(new Livro("Guerra e Paz", "Liev Tolstói", 1869));
        arvore.inserir(new Livro("Anna Kariênina", "Liev Tolstói", 1878));
        arvore.inserir(new Livro("A Morte de Ivan Ilitch", "Liev Tolstói", 1886));
        arvore.inserir(new Livro("A Metamorfose", "Franz Kafka", 1915));
        arvore.inserir(new Livro("O Processo", "Franz Kafka", 1925));
        arvore.inserir(new Livro("O Castelo", "Franz Kafka", 1926));

        System.out.println("--- Todos os livros em ordem alfabética ---");
        arvore.exibirEmOrdem();
    }
}
