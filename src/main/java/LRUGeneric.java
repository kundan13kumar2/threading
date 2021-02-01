import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public class LRUGeneric<K,V> {

    private K key;
    private V val;
    Map<K, V> cache = new ConcurrentHashMap<>();
    Queue<K> queue = new LinkedList<>();

    int cacheLength;

    public LRUGeneric(int cacheLength) {
        this.cacheLength = cacheLength;
    }

    public V getVal(K key) {
        return cache.get(key);
    }

    public void putVal(K key, V val) {
        int size = queue.size();
        if (cache.containsKey(key)) {
            //Custom eviction Policy
            queue.remove(key);
        }else {
            if(size==cacheLength){
                queue.poll();
                cache.remove(key);
            }
        }
        queue.add(key);
        cache.put(key, val);
    }


    public static void main(String[] args) {


    }


}
