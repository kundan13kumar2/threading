package genericCache;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class GenericCache<K, V> implements IGenericCache<K, V> {

    protected interface CacheValue<V> {
        V getValue();
        LocalDateTime getCreatedAt();
    }

    public GenericCache( long timeout) {
        this.timeout = timeout;
    }

    private Map<K, CacheValue<V>> cacheMap;
    private long timeout;

    @Override
    public void clean() {

    }

    @Override
    public void clear() {
        cacheMap=new ConcurrentHashMap<>();
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.empty();
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void remove(K key) {

    }
}
