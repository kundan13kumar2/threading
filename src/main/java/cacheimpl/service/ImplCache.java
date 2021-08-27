package cacheimpl.service;

import cacheimpl.cacheInterface.Cache;
import java.util.*;

public class ImplCache implements Cache {

    int cacheSize;
    Map<Integer, Integer> cache;
    int currSize;
    Set<Integer> keys;

    public ImplCache(int cacheSize) {
        this.cacheSize = cacheSize;
        cache = new LinkedHashMap<>();
        currSize = 0;
        keys = new LinkedHashSet<>();
    }

    @Override
    public void put(Integer key, Integer value) {
        if (cacheSize == currSize) {
            if (!keys.contains(key))
                remove();
        } else if (!keys.contains(key))
            currSize++;

        keys.add(key);
        cache.put(key, value);
    }

    @Override
    public Integer get(Integer key) {
        if (key == null || cache.get(key) == null)
            return null;
        return cache.get(key);
    }

    @Override
    public boolean isEmpty() {
        return currSize < cacheSize;
    }

    @Override
    public void remove() {
        Integer key = new ArrayList<>(keys).get(keys.size() - 1);
        cache.remove(key);
        keys.remove(key);
    }

    @Override
    public void removeKey(Integer key) {
        cache.remove(key);
        keys.remove(key);
        currSize--;
    }

    @Override
    public void printCache() {
        for (Map.Entry<Integer, Integer> entry : cache.entrySet())
            System.out.println(entry.getKey() + " : " + entry.getValue());
    }


}
