package com.sb.algorithms.hexlet.concurrency.module0.e1;

import com.sb.algorithms.hexlet.concurrency.module0.ITextLoader;

public class TextLoaderThread extends Thread{

    private final ITextLoader textLoader;

    public TextLoaderThread(final ITextLoader textLoader) {
        this.textLoader = textLoader;
    }

    @Override
    public void run() {
        System.out.println(textLoader.loadText());
    }
}
