package com.sb.algorithms.hexlet.concurrency.module0.e1;

import com.sb.algorithms.hexlet.concurrency.module0.ITextLoader;

public class ThreadLoaderRunnable implements Runnable {
    private final ITextLoader loader;

    public ThreadLoaderRunnable(final ITextLoader loader) {
        this.loader = loader;
    }

    @Override
    public void run() {
        System.out.println(loader.loadText());
    }
}
