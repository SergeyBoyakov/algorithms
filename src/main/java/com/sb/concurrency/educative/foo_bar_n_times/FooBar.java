package com.sb.concurrency.educative.foo_bar_n_times;

public class FooBar {
    private int timesToPrintFooAndBar;
    private int flag=0; // if print foo -> 0, if print bar -> 1

    public FooBar(final int timesToPrintFooAndBar) {
        this.timesToPrintFooAndBar = timesToPrintFooAndBar;
    }

    public void foo() {
        for (int i = 0; i < timesToPrintFooAndBar; i++) {
            synchronized (this) {
                while (flag == 1) {
                    try {
                        this.wait();
                    } catch (InterruptedException interruptedException) {
                        // noop
                    }
                }
                System.out.println("Foo");
                flag=1;
                this.notifyAll();
            }
        }
    }

    public void bar() {
        for (int i = 0; i < timesToPrintFooAndBar; i++) {
            synchronized (this) {
                while (flag == 0) {
                    try{
                        this.wait();
                    } catch (InterruptedException interruptedException) {
                        //noop
                    }
                }
                System.out.println("Bar");
                flag = 0;
                this.notifyAll();
            }
        }

    }

}
