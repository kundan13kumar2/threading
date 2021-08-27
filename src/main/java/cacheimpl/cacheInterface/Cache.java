package cacheimpl.cacheInterface;

public interface Cache {

    void put(Integer key, Integer value);

    Integer get(Integer key);

    boolean isEmpty();

    void remove();

    void removeKey(Integer key);

    void printCache();
}
