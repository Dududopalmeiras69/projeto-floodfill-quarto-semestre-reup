package estrutura;
import java.util.LinkedList;

public class Fila<T> {
    private LinkedList<T> fila = new LinkedList<>();

    public void offer(T elementos){
        fila.addLast(elementos);
    }

    public T poll(){
        return fila.pollFirst();
    }
    public T peek(){
        return fila.peekFirst();
    }

    public boolean espacoVazio(){
        return fila.isEmpty();
    }
}
