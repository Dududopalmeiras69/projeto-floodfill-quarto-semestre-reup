package estrutura;

public class No<T> {
    T valor;
    No<T> anterior;
    No<T> proximo;

    public No(T valor){
        this.valor = valor;
    }
    class listaDupla<T>{
        private No<T> topo;
        private No<T> base;
        private int size;

        private boolean estaVazia(){
            return size == 0;
        }
        private boolean estaCheia(){
            return false;
        }
        private int getSize(){
            return size;
        }

        public void add(int pos, T valor){

        }
        public void add(T valor){
            No<T> no = new No<>(valor);
        }
        private T remove(int pos){
            return null;
        }
        private T remove(No<T> node){
            return null;
        }
        private No<T> getNo(int pos){
            return null;
        }
        private T get(int pos){
            return null;
        }
        public void set(int pos, T valor){

        }
        public int find(T valor){
            return 0;
        }
    }
}
