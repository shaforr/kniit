import java.util.HashMap;
import java.util.Map;

public class Dictionary<K, V> {

    private Map<K, V> data = new HashMap<>();

    public void put(K key, V value) {
        data.put(key, value);
    }

    public V get(K key) {
        return data.get(key);
    }

    public void remove(K key) {
        data.remove(key);
    }

    public boolean containsKey(K key) {
        return data.containsKey(key);
    }
}
