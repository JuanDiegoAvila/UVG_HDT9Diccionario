import java.util.Comparator;

public class SplayTree <K extends Comparable<K>,V>  implements Map<K,V>  {

    private Node raiz;

    private class Node {
        private K key;                  //llave
        private V value;                //valor asociado
        private Node derecha,izquierda; //sub arboles izquierdo y derecho

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return get(key) !=null;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    /**
     * si no existe el valor, regresar nulo
     * @param key
     * @return el valor asociado con la llave
     */
    @Override
    public V get(K key) {
        raiz = splay(raiz,key);
        int cmp = key.compareTo(raiz.key);
        if (cmp == 0) return raiz.value;
        else return null;
    }

    private Node splay(Node raiz, K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void put(K key, V value) {
        if(raiz == null){
            raiz = new Node(key, value);
            return;
        }
        raiz = splay(raiz,key);
        int cmp = key.compareTo(raiz.key);

        if (cmp < 0) {
            Node n = new Node(key, value);
            n.izquierda = raiz.izquierda;
            n.derecha = raiz;
            raiz.izquierda = null;
            raiz = n;
        }


        else if (cmp > 0) {
            Node n = new Node(key, value);
            n.derecha = raiz.derecha;
            n.izquierda = raiz;
            raiz.derecha = null;
            raiz = n;
        }


        else {
            raiz.value = value;
        }

    }

    @Override
    public void remove(K key) {
    }

    @Override
    public int size() {
        return 0;
    }
}
