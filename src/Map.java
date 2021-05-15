public interface Map<K,V>{

    public void clear();

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public boolean equals(Object o);

    public V get(K key);

    public boolean isEmpty();

    public void put(K key,V value);

    public void remove(K key);

    public int size();


}
