package com.mjc.stage2;

public class ThreadSafeSingleton {
    private volatile static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}

    public synchronized static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }

        return instance;
    }
}
