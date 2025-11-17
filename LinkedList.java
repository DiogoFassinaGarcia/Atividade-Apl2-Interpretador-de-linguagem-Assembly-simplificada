public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }


    // ADICIONAR NODE NO FINAL DA LISTA

    public void addLast(T linha, T comando, T var1, T var2) {
        Node<T> novo = new Node<>(linha, comando, var1, var2, null);

        if (isEmpty()) {
            head = novo;
        } else {
            Node<T> atual = head;
            while (atual.getProx() != null) {
                atual = atual.getProx();
            }
            atual.setProx(novo);
        }
        size++;
    }


    // ADICIONAR EM POSIÇÃO BASEADA EM valor linha

    public void addById(T linha, T comando, T var1, T var2) {
        Node<T> novo = new Node<>(linha, comando, var1, var2, null);

        // Lista vazia → insere no início
        if (isEmpty()) {
            head = novo;
            size++;
            return;
        }

        Node<T> atual = head;
        Node<T> anterior = null;

        // Procuramos posição onde linha atual > linha nova
        while (atual != null && ((Comparable) atual.getLinha()).compareTo(linha) < 0) {
            anterior = atual;
            atual = atual.getProx();
        }

        // Inserção no início
        if (anterior == null) {
            novo.setProx(head);
            head = novo;
        } else {
            novo.setProx(atual);
            anterior.setProx(novo);
        }

        size++;
    }


    // REMOVER NODE POR LINHA

    public boolean removeById(T linha) {

        if (isEmpty()) return false;

        Node<T> atual = head;
        Node<T> anterior = null;

        while (atual != null && !atual.getLinha().equals(linha)) {
            anterior = atual;
            atual = atual.getProx();
        }

        if (atual == null) return false; // não achou

        if (anterior == null) {
            head = atual.getProx(); // remover primeiro
        } else {
            anterior.setProx(atual.getProx());
        }

        size--;
        return true;
    }


    //  IMPRIMIR LISTA

    public void printList() {

        if (isEmpty()) {
            System.out.println("[ Lista vazia ]");
            return;
        }

        Node<T> atual = head;

        while (atual != null) {
            System.out.println(
                "Linha: " + atual.getLinha() +
                " | Comando: " + atual.getComando() +
                " | Var1: " + atual.getVar1() +
                " | Var2: " + atual.getVar2()
            );

            atual = atual.getProx();
        }

        System.out.println("\nTotal de elementos: " + size);
    }

    //LIMPAR LISTA

    public void clear() {
        head = null;
        size = 0;
    }

	public boolean contains(int linha) {
    Node atual = head;

    while (atual != null) {
        if (atual.getLinha() != null && atual.getLinha().equals(linha)) {
            return true;
        }
        atual = atual.getProx();
    }

    return false;
	}

	public Node search(int linha) {
    Node atual = head;

    while (atual != null) {
        if (atual.getLinha() != null && atual.getLinha().equals(linha)) {
            return atual;
        }
        atual = atual.getProx();
    }

    return null; // não encontrado
	}


}
