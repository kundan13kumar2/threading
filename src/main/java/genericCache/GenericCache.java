package genericCache;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class GenericCache<K, V> implements IGenericCache<K, V> {

    protected interface CacheValue<V> {
        V getValue();

        LocalDateTime getCreatedAt();
    }

    public GenericCache(long timeout) {
        cacheMap = new ConcurrentHashMap<>();
        this.timeout = timeout;
    }

    private Map<K, CacheValue<V>> cacheMap;
    private final long timeout;

    @Override
    public void clean() {
        Set<K> expiredKey = getExpiredKeys();
        for (K key : expiredKey)
            this.remove(key);
    }

    protected Set<K> getExpiredKeys() {
        return cacheMap.keySet().parallelStream().filter(this::isExpired).collect(Collectors.toSet());
    }

    protected boolean isExpired(K key) {
        LocalDateTime expirationDateTime = cacheMap.get(key).getCreatedAt().plus(this.timeout, ChronoUnit.MILLIS);
        return LocalDateTime.now().isAfter(expirationDateTime);
    }

    @Override
    public void clear() {
        cacheMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean containsKey(K key) {
        return this.cacheMap.containsKey(key);
    }

    @Override
    public Optional<V> get(K key) {
        this.clean();
        return Optional.ofNullable(cacheMap.get(key)).map(CacheValue::getValue);
    }

    @Override
    public void put(K key, V value) {
        this.cacheMap.put(key, this.createCachedValue(value));
    }

    protected CacheValue<V> createCachedValue(V value) {
        LocalDateTime now = LocalDateTime.now();
        return new CacheValue<V>() {
            @Override
            public V getValue() {
                return value;
            }

            @Override
            public LocalDateTime getCreatedAt() {
                return now;
            }
        };
    }

    @Override
    public void remove(K key) {
        this.cacheMap.remove(key);
    }

    public static void main(String[] args) throws InterruptedException {
        IGenericCache<Integer, String> cache = new GenericCache<>(10000);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        System.out.println(cache.get(1));
        Thread.sleep(5000);
        System.out.println(cache.get(2));
        Thread.sleep(5000);
        System.out.println(cache.get(3));

    }
}
