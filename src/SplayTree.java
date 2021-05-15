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
    public boolean containsKey(K key) {
        return get(key) !=null;
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

    private Node splay(Node h, K key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.key);

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.izquierda == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.izquierda.key);
            if (cmp2 < 0) {
                h.izquierda.izquierda = splay(h.izquierda.izquierda, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                h.izquierda.derecha = splay(h.izquierda.derecha, key);
                if (h.izquierda.derecha != null)
                    h.izquierda = rotateLeft(h.izquierda);
            }

            if (h.izquierda == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) {
            // key not in tree, so we're done
            if (h.derecha == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.derecha.key);
            if (cmp2 < 0) {
                h.derecha.izquierda  = splay(h.derecha.izquierda, key);
                if (h.derecha.izquierda != null)
                    h.derecha = rotateRight(h.derecha);
            }
            else if (cmp2 > 0) {
                h.derecha.derecha = splay(h.derecha.derecha, key);
                h = rotateLeft(h);
            }

            if (h.derecha == null) return h;
            else                 return rotateLeft(h);
        }

        else return h;
    }

    public int height() { return height(raiz); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.izquierda), height(x.derecha));
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
        if (raiz == null) return; // empty tree

        raiz = splay(raiz, key);

        int cmp = key.compareTo(raiz.key);

        if (cmp == 0) {
            if (raiz.izquierda == null) {
                raiz = raiz.derecha;
            }
            else {
                Node x = raiz.derecha;
                raiz = raiz.izquierda;
                splay(raiz, key);
                raiz.derecha = x;
            }
        }
    }

    @Override
    public int size() {
        return size(raiz);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return 1 + size(x.izquierda) + size(x.derecha);
    }

    private Node rotateRight(Node h) {
        Node x = h.izquierda;
        h.izquierda = x.derecha;
        x.derecha = h;
        return x;
    }

    // left rotate
    private Node rotateLeft(Node h) {
        Node x = h.derecha;
        h.derecha = x.izquierda;
        x.izquierda = h;
        return x;
    }
}
