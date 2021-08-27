package cacheimpl;

import cacheimpl.cacheInterface.Cache;
import cacheimpl.service.ImplCache;

public class CacheTest {

    public static void main(String[] args) {
        Cache cache = new ImplCache(3);
        cache.put(2, 6);
        cache.put(3, 5);
        cache.printCache();
        System.out.println("-----------------");
        System.out.println();

        cache.put(2, 9);
        cache.printCache();
        System.out.println("-----------------");
        System.out.println();

        cache.put(4, 3);
        cache.printCache();
        System.out.println("-----------------");
        System.out.println();

        System.out.println(cache.get(2));
        cache.printCache();
        System.out.println("-----------------");
        System.out.println();

        cache.put(5, 7);
        cache.printCache();
        System.out.println("-----------------");
        System.out.println();

        System.out.println(cache.get(5));


    }
}
