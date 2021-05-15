import java.util.ArrayList;

public class HashMap<K,V> implements Map <K,V>{

    private final ArrayList<K> keys;
    private final ArrayList<V> values;
    private int index;

    public HashMap(){
        keys = new ArrayList<K>();
        values = new ArrayList<>();
        index=0;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public Object get(K key) {
        int i=keys.indexOf(key);
        if (i>=0)
            return values.get(i);

        else
            return null;
    }


    @Override
    public void put(K key, V value) {
        keys.add(key);
        values.add(value);
        index++;
    }


}
