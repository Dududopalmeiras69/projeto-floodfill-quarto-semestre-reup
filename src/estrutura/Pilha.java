package estrutura;

public class Pilha<T> {
    private No<T> topo;
    //adiciona um item ao topo da pilha
    public void push(T valor) {
        No<T> novo = new No<>(valor);
        novo.proximo = topo;
        topo = novo;
    }
    //remove o primeiro item da pilha para
    public T pop() {
        if (topo == null) return null;

        T valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}