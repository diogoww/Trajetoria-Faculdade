// mome: Diogo José Varaschin de Oliveira
// curso: Análise e Desenvolvimento de Sistemas - PUCPR
// matéria: Métodos de Pesquisa e Ordenação em Estruturas de Dados

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
