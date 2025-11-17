public class Node<T> {

    private T linha;
	private T comando;
	private T var1;
	private T var2;
    private Node<T> prox;

    public Node() {}

    public Node(T linha,T comando,T var1,T var2, Node<T> prox) {
        this.linha = linha;
		this.comando = comando;
		this.var1 = var1;
		this.var2 = var2;
        this.prox = prox;
    }

    public T getLinha() {
        return linha;
    }

    public void setLinha(T dado) {
        this.linha = dado;
    }

	 public T getComando() {
        return comando;
    }

    public void setComando(T dado) {
        this.comando = dado;
    }

	 public T getVar1() {
        return var1;
    }

    public void setVar1(T dado) {
        this.var1 = dado;
    }

	 public T getVar2() {
        return var2;
    }

    public void setVar2(T dado) {
        this.var2 = dado;
    }

    public Node<T> getProx() {
        return prox;
    }

    public void setProx(Node<T> prox) {
        this.prox = prox;
    }
}