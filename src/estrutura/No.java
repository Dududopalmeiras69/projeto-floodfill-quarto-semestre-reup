package estrutura;

public class No<T> {
    No<T> topo;
    No<T> base;
    int size;

    private boolean estaVazia(){}
    private boolean estaCheia(){}
    private int getSize(){}

    public void add(int pos, T valor){}

    public void add(T valor){}

    private T remove(int pos){}

    private T remove(No<T> node){}

    private No<T> getNo(int pos){}

    private T get(int pos){}

    public void set(int pos, T valor){}
    public int find(T valor){}
}
