package com.sb.concurrency.educative.blocking_queue_mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Blocking queue problem synchronized approach
 *
 * @param <T>
 */
public class BlockingQueueWithMutex<T> {
    T[] array;
    final Lock lock = new ReentrantLock();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("unchecked")
    public BlockingQueueWithMutex(final int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(final T item) throws InterruptedException {
        lock.lock();
        while (size == capacity) { // we check it while holding the mutex
            // Release mutex to give other threads
            lock.unlock();
            // Reacquire the mutex before checking the condition
            lock.lock();
        }

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        lock.unlock();
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        lock.lock();
        while (size == 0) {
            lock.unlock();
            lock.lock();
        }

        if (head == capacity) {
            head=0;
        }
        item = array[head];
        array[head] = null;
        head++;
        size--;

        lock.unlock();
        return item;
    }
}
