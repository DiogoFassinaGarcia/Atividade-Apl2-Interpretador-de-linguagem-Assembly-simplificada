import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arquivo{

    public static void ler(String nomeArquivo){

        File arquivo = new File(nomeArquivo);

        LinkedList lista = new LinkedList<T>();

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                

                int newLinha = sc.next();

                int newComando = sc.next();

                int newVar1 = sc.next();

                int newVar2 = sc.next();

                lista.addFirst(newLinha, newComando, newVar1, newVar2);


            }

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }

    private static <T> void escreverNoRecursivo(Node<T> atual, PrintWriter writer) {
        if (atual == null) {
            return;
        }

        // O método 'toString()' é usado para converter o tipo genérico T para String.
        String linhaFormatada = String.format("%s %s %s %s",
            atual.getLinha(),
            atual.getComando(),
            atual.getVar1(),
            atual.getVar2());
            
        writer.println(linhaFormatada); // Escreve a linha e um newline

        escreverNoRecursivo(atual.getProx(), writer);
    }
    
    /**
     * Método público para iniciar a escrita recursiva.
     * @param nomeArquivo O nome do arquivo onde escrever.
     * @param head O primeiro nó (cabeça) da lista encadeada.
     * @param append Se true, anexa; se false, sobrescreve.
     */
    public static <T> void escreverRecursivo(String nomeArquivo, Node<T> head, boolean append) {
        if (head == null) {
            System.out.println("A lista está vazia, nada a escrever.");
            return;
        }

        try (FileWriter fileWriter = new FileWriter(nomeArquivo, append);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            
            // Chama a função recursiva auxiliar
            escreverNoRecursivo(head, printWriter);
            
            System.out.println("Dados da lista escritos recursivamente em: " + nomeArquivo);
            
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
