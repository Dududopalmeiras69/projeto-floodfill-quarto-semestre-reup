package estrutura;

public class No<T> {
    T valor;
    No<T> proximo;
    No(T valor){
        this.valor = valor;
    }
    private No<T> head;
    private int tamanho;

    public void add(T valor){
        No<T> novoNo = new No<>(valor);
        if (head == null){
            head = novoNo;
        } else {
            No<T> atual = head;
            while (atual.proximo != null) atual = atual.proximo;
            atual.proximo = novoNo;
        }
        tamanho++;
    }
}
