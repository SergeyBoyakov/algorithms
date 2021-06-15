package com.sb.concurrency.educative.unisex_bath_problem;

import java.util.concurrent.Semaphore;

public class UnisexBathroom {
    static final String WOMEN = "women";
    static final String MEN = "men";
    static final String NONE = "none";

    String inUseBy = NONE;
    int empsInBathroom = 0;
    Semaphore semaphore = new Semaphore(3);

    void useBathroom(final String name) throws InterruptedException {
        System.out.println(name + " using bathroom. Current employees in bathroom = " + empsInBathroom);
        Thread.sleep(10_000);
        System.out.println(name + " done using bathroom");
    }

    void maleUseBathroom(final String name) throws InterruptedException {

        // if we make method level sync -> only one man will be able to useBathroom, but we need that several
        // men should be able to use bathroom at the time, so we move sync to block inside the method
        synchronized (this) {
            while (inUseBy.equals(WOMEN)) {
                // The wait call will give up the monitor associated
                // with the object, giving other threads a chance to
                // acquire it.
                this.wait();
            }
            semaphore.acquire();
            empsInBathroom++;
            inUseBy = MEN;
        }

        useBathroom(name); // mock the person using bathroom
        semaphore.release();

        synchronized (this) {
            empsInBathroom--;
            if (empsInBathroom == 0) inUseBy = NONE;
            // Since we might have just updated the value of inUseBy, we should notifyAll waiting threads
            this.notifyAll();
        }

    }

    void femaleUseBathroom(final String name) throws InterruptedException {
        synchronized (this) {
            while (inUseBy.equals(MEN)) {
                this.wait();
            }
            semaphore.acquire();
            empsInBathroom++;
            inUseBy = WOMEN;
        }

        useBathroom(name);  // mock the person using bathroom
        semaphore.release();

        synchronized (this) {
            empsInBathroom--;

            if (empsInBathroom == 0) inUseBy = NONE;
            // Since we might have just updated the value of inUseBy, we should notifyAll waiting threads
            this.notifyAll();
        }
    }
}
