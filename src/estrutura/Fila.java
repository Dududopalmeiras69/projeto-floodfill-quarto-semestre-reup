package estrutura;

public class Fila<T> extends No<T> {
    private No<T> inicio;
    private No<T> fim;

    public Fila(T proximo){
        super(proximo);
    }
    public void enqueue(T valor) {
        No<T> novo = new No<>(valor);

        if (fim != null) {
            fim.proximo = novo;
        }

        fim = novo;

        if (inicio == null) {
            inicio = novo;
        }
    }

    public T dequeue() {
        if (inicio == null) return null;

        T valor = inicio.valor;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }

        return valor;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}