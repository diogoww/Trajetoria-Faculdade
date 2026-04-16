//classe do nó da arvore
public class NoLivro {

    Livro livro;
    NoLivro esquerda;
    NoLivro direita;

    public NoLivro(Livro livro){
        this.livro = livro;
        this.esquerda = null;
        this.direita = null;
    }
}
