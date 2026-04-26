// mome: Diogo José Varaschin de Oliveira
// curso: Análise e Desenvolvimento de Sistemas - PUCPR
// matéria: Métodos de Pesquisa e Ordenação em Estruturas de Dados

import java.util.*;

public class Main {

    public static void main(String[] args){

        ArvoreBiblioteca arvore = new ArvoreBiblioteca();

        Livro l1 = new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866);
        Livro l2 = new Livro("Os Irmãos Karamazov", "Fiódor Dostoiévski", 1880);
        Livro l3 = new Livro("Noites Brancas", "Fiódor Dostoiévski", 1848);
        Livro l4 = new Livro("Notas do Subterrâneo", "Fiódor Dostoiévski", 1864);
        Livro l5 = new Livro("Guerra e Paz", "Liev Tolstói", 1869);
        Livro l6 = new Livro("Anna Kariênina", "Liev Tolstói", 1878);
        Livro l7 = new Livro("A Morte de Ivan Ilitch", "Liev Tolstói", 1886);
        Livro l8 = new Livro("A Metamorfose", "Franz Kafka", 1915);
        Livro l9 = new Livro("O Processo", "Franz Kafka", 1925);
        Livro l10 = new Livro("O Castelo", "Franz Kafka", 1926);

        Livro[] livros = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};

        for (Livro livro : livros){
            arvore.inserir(livro);
        }

        System.out.println("--- Todos os livros em ordem alfabética ---");
        arvore.exibirEmOrdem();

        HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();

        for (Livro livro : livros){
            recomendacoes.put(livro, new HashSet<>());
        }

        recomendacoes.get(l1).add(l2);
        recomendacoes.get(l1).add(l4);

        recomendacoes.get(l2).add(l1);
        recomendacoes.get(l2).add(l5);

        recomendacoes.get(l3).add(l1);
        recomendacoes.get(l3).add(l8);

        recomendacoes.get(l4).add(l1);
        recomendacoes.get(l4).add(l9);

        recomendacoes.get(l5).add(l6);
        recomendacoes.get(l5).add(l7);

        recomendacoes.get(l6).add(l5);
        recomendacoes.get(l6).add(l2);

        recomendacoes.get(l7).add(l5);
        recomendacoes.get(l7).add(l10);

        recomendacoes.get(l8).add(l9);
        recomendacoes.get(l8).add(l10);

        recomendacoes.get(l9).add(l8);
        recomendacoes.get(l9).add(l10);

        recomendacoes.get(l10).add(l8);
        recomendacoes.get(l10).add(l9);

        System.out.println("\n--- Distâncias a partir de Noites Brancas ---");

        Map<Livro, Integer> distancias = dijkstraSimples(recomendacoes, l3);

        for (Map.Entry<Livro, Integer> entry : distancias.entrySet()) {
            System.out.println(
                    entry.getKey().getTitulo() +
                            " -> distância: " +
                            entry.getValue()
            );
        }
    }

    public static Map<Livro, Integer> dijkstraSimples(
            HashMap<Livro, Set<Livro>> grafo,
            Livro origem) {

        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }

        return distancias;
    }
}
