import java.util.Objects;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                " | Autor: " + autor +
                " | Ano: " + anoPublicacao;
    }

    @Override
    public boolean equals(Object objects){
        if (this == objects) return true;
        if (objects == null || getClass() != objects.getClass()) return false;

        Livro livro = (Livro) objects;
        return titulo.equals(livro.titulo);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(titulo);
    }
}
