package estrutura;

public class Pilha<T> {
    private T[] fim;
    private int topo;
    private static final int capacidade_total = 1024;
    Pilha<T> pilha = new Pilha<T>();

    public Pilha(){
        this.fim = (T[]) new Object[capacidade_total];
        this.topo = -1;
    }

    private void ajustePilha(int capacidade){
        T[] tmp = (T[]) new Object[capacidade];
        for (int i = 0; i <= topo; i++){
            tmp[i] = this.fim[i];
        }
        this.fim = tmp;
    }

    public void push(T elementos){
        if (topo == fim.length - 1){
        ajustePilha(2 * fim.length);
        }
        fim[++topo] = elementos;
    }
    public void pop(){
        if(espacoVazio()){
            throw new RuntimeException("NÃO TEM NADA AQUI");
        }
        fim[topo] = null;
        topo--;

        if (topo > 0 && topo == fim.length/4){
            ajustePilha(fim.length/2);
        }
    }
    public T peek(){
        if(espacoVazio()){
            throw new RuntimeException("NÃO TEM NADA AQUI");
        }
        return fim[topo];
    }

    public boolean espacoVazio(){
        return topo == -1;
    }
}
