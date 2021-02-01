package genericCache;

import java.util.Optional;

public interface IGenericCache<K, V> {

    // Removed expired keys from the cache
    void clean();

    //Refresh cache and removed all keys
    void clear();

    //Check key contains or not in cache
    boolean containsKey(K key);

    //Get data from cache for given key
    Optional<V> get(K key);

    //Put key,value into cache
    void put(K key, V value);

    //Removed a particular key from cache
    void remove(K key);
}
