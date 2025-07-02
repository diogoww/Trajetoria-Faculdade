package FinanciamentoImobiliarios.util;

import FinanciamentoImobiliarios.Apartamento;
import FinanciamentoImobiliarios.Casa;
import FinanciamentoImobiliarios.Terreno;
import FinanciamentoImobiliarios.modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class GerenciadorArquivos {

    private static final String NOME_ARQUIVO_TEXTO = "financiamentos.txt";
    private static final String NOME_ARQUIVO_BINARIO = "financiamentos.ser";
    private static final String DELIMITADOR = ";";

    public static void gravarFinanciamentosTexto(ArrayList<Financiamento> financiamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO_TEXTO))) {
            for (Financiamento f : financiamentos) {
                StringBuilder linha = new StringBuilder();
                linha.append(f.getClass().getSimpleName()).append(DELIMITADOR);
                linha.append(f.getValorImovel()).append(DELIMITADOR);
                linha.append(f.getTaxaJurosAnual()).append(DELIMITADOR);
                linha.append(f.getPrazoFinanciamento()).append(DELIMITADOR);
                try {
                    linha.append(f.calcPagamentoTotal()).append(DELIMITADOR);
                } catch (Exception e) {
                    linha.append("ERRO_CALCULO").append(DELIMITADOR);
                }

                if (f instanceof Casa) {
                    linha.append(((Casa) f).getAreaConstruida());
                } else if (f instanceof Apartamento) {
                    linha.append(((Apartamento) f).getNumeroAndar());
                } else if (f instanceof Terreno) {
                    linha.append(((Terreno) f).getTipoTerreno());
                }
                writer.write(linha.toString());
                writer.newLine();
            }
            System.out.println("\n--- Dados dos financiamentos salvos em " + NOME_ARQUIVO_TEXTO + " ---");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados no arquivo de texto: " + e.getMessage());
        }
    }

    public static void serializarFinanciamentos(ArrayList<Financiamento> financiamentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_BINARIO))) {
            oos.writeObject(financiamentos);
            System.out.println("\n--- Financiamentos serializados e salvos em " + NOME_ARQUIVO_BINARIO + " ---");
        } catch (IOException e) {
            System.err.println("Erro ao serializar financiamentos: " + e.getMessage());
        }
    }

    public static ArrayList<Financiamento> lerFinanciamentosTexto() {
        ArrayList<Financiamento> financiamentosLidos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO_TEXTO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(DELIMITADOR);
                if (dados.length < 5) {
                    System.err.println("Linha inválida no arquivo: " + linha);
                    continue;
                }

                String tipo = dados[0];
                double valorImovel = Double.parseDouble(dados[1]);
                double taxaJuros = Double.parseDouble(dados[2]);
                int prazoAnos = Integer.parseInt(dados[3]);

                Financiamento financiamento = null;
                switch (tipo) {
                    case "Casa":
                        double areaConstruida = Double.parseDouble(dados[5]);
                        financiamento = new Casa(valorImovel, taxaJuros, prazoAnos, areaConstruida);
                        break;
                    case "Apartamento":
                        int numeroAndar = Integer.parseInt(dados[5]);
                        financiamento = new Apartamento(valorImovel, taxaJuros, prazoAnos, numeroAndar);
                        break;
                    case "Terreno":
                        String tipoTerreno = dados[5];
                        financiamento = new Terreno(valorImovel, taxaJuros, prazoAnos, tipoTerreno);
                        break;
                    default:
                        System.err.println("Tipo de financiamento desconhecido: " + tipo);
                        break;
                }
                if (financiamento != null) {
                    financiamentosLidos.add(financiamento);
                }
            }
            System.out.println("\n--- Dados dos financiamentos lidos do arquivo de texto ---");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo de texto não encontrado: " + NOME_ARQUIVO_TEXTO);
        } catch (IOException e) {
            System.err.println("Erro ao ler dados do arquivo de texto: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro de formato de número ao ler arquivo de texto: " + e.getMessage());
        }
        return financiamentosLidos;
    }

    public static ArrayList<Financiamento> deserializarFinanciamentos() {
        ArrayList<Financiamento> financiamentosLidos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_BINARIO))) {
            financiamentosLidos = (ArrayList<Financiamento>) ois.readObject();
            System.out.println("\n--- Financiamentos deserializados de " + NOME_ARQUIVO_BINARIO + " ---");
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo serializado não encontrado: " + NOME_ARQUIVO_BINARIO);
        } catch (IOException e) {
            System.err.println("Erro de I/O ao deserializar financiamentos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Classe não encontrada durante deserialização: " + e.getMessage());
        } catch (ClassCastException e) {
            System.err.println("Erro de casting durante deserialização: " + e.getMessage());
        }
        return financiamentosLidos;
    }
}