package com.thread.learn.com.thread.guavalibexercise.basic;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaLibTest {

    public static void main(String[] args) {

        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                return s.toUpperCase();
            }
        };


        LoadingCache cache;

        cache= CacheBuilder.newBuilder().build(loader);

        System.out.println(cache.size());
        System.out.println(cache.getUnchecked("Hello"));
        System.out.println(cache.size());

    }
}
