package com.sb.concurrency.educative.barbershop;

import com.sun.source.tree.UsesTree;

import java.util.HashSet;
import java.util.Set;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        final Set<Thread> customers = new HashSet<>();
        final BarberShopProblem barberShopProblem = new BarberShopProblem();

        Thread barberThread = new Thread(() -> {
            try {
                barberShopProblem.barber();
            } catch (InterruptedException interruptedException) {
                // noop
            }
        });

        barberThread.start();

        for (int i = 0; i < 10; i++) {
            Thread customer = new Thread(() -> {
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException ie) {
                    // noop
                }
            });
            customers.add(customer);
        }

        for (Thread t : customers) {
            t.start();
        }

        for (Thread t : customers) {
            t.join();
        }

        customers.clear();
        Thread.sleep(500);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(()->{
                try {
                    barberShopProblem.customerWalksIn();
                } catch (InterruptedException interruptedException) {
                    // noop
                }
            });
            customers.add(t);
        }

        for (Thread t : customers) {
            t.start();
            Thread.sleep(5);
        }

        barberThread.join();
    }
}
