public class ArvoreBiblioteca {

    private NoLivro raiz;

    public void inserir(Livro livro){
        raiz = inserirRec(raiz, livro);
    }

    private NoLivro inserirRec(NoLivro raiz, Livro livro){

        if (raiz == null) {
            return new NoLivro(livro);
        }

        if (livro.getTitulo().compareToIgnoreCase(raiz.livro.getTitulo()) < 0){
            raiz.esquerda = inserirRec(raiz.esquerda, livro);
        } else {
            raiz.direita = inserirRec(raiz.direita, livro);
        }

        return raiz;
    }

    private void exibirEmOrdemRec(NoLivro raiz){
        if (raiz != null){
            exibirEmOrdemRec(raiz.esquerda);
            System.out.println(raiz.livro);
            exibirEmOrdemRec(raiz.direita);
        }
    }

    public void exibirEmOrdem(){
        exibirEmOrdemRec(raiz);
    }
}
