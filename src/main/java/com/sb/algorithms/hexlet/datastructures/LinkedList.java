package com.sb.algorithms.hexlet.datastructures;

import java.util.*;

public class LinkedList<T> implements List<T> {

    private Item<T> firstInList = null;

    private Item<T> lastInList = null;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)
        return false;
        // END
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator(0);
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)
        return null;
        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)
        return null;
        // END
    }

    @Override
    public boolean add(final T newElement) {
        // BEGIN (write your solution here)
        if (firstInList == null) {
            firstInList = new Item<T>(newElement, null, null);
            lastInList = firstInList;
            size++;
        } else {
            lastInList.nextItem = new Item<>(newElement, lastInList, null);
            lastInList = lastInList.nextItem;
            size++;
        }

        return true;
        // END
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)
        return true;
        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final T item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException {
        // BEGIN (write your solution here)
        return null;
        // END
    }


    private void remove(final Item<T> current) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object o) {
        // BEGIN (write your solution here)
        return 0;
        // END
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)
        return null;
        // END
    }

    @Override
    public T get(final int index) {
        // BEGIN (write your solution here)
        return getItemByIndex(index).element;
        // END
    }

    private Item<T> getItemByIndex(final int index) {
        // BEGIN (write your solution here) An auxiliary method for searching for node by index.
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }

        if (index == 0) {
            return firstInList;
        }

        int currentIndex = 0;
        Item<T> currentItem = LinkedList.this.firstInList;
        while (currentIndex < index) {
            currentItem = currentItem.nextItem;
            currentIndex++;
        }

        return currentItem;
        // END
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> currentItemInIterator;
        private Item<T> lastReturnedItemFromIterator;
        private int index = 0;
        private Boolean nextCalled = null;

        ElementsIterator(final int index) {
            // BEGIN (write your solution here)
            this.index = index;
            this.currentItemInIterator = getItemByIndex(index);
            // END
        }

        @Override
        public boolean hasNext() {
            // BEGIN (write your solution here)
            if (lastReturnedItemFromIterator == null)
                return currentItemInIterator != null;

            return lastReturnedItemFromIterator.nextItem != null;
            // END
        }

        @Override
        public T next() {
            // BEGIN (write your solution here)
            if (size == 0) {
                throw new NoSuchElementException();
            }

            if (index >= size || index < -1) {
                throw new NoSuchElementException();
            }

            if (currentItemInIterator == null) {
                throw new NoSuchElementException();
            }

            Item<T> nextItem = this.currentItemInIterator;

            index++;
            nextCalled = true;

            lastReturnedItemFromIterator = currentItemInIterator;
            currentItemInIterator = currentItemInIterator.nextItem;

            return nextItem.element;
            // END
        }

        @Override
        public boolean hasPrevious() {
            // BEGIN (write your solution here)
            return index > 0;
            // END
        }

        @Override
        public T previous() {
            // BEGIN (write your solution here)
            if (size == 0)
                throw new NoSuchElementException();

            if (index > size || index < 0) {
                throw new NoSuchElementException();
            }

            if (index == size) {
                Item<T> previousItem = LinkedList.this.lastInList;
                index--;
                nextCalled = false;

                currentItemInIterator = previousItem;
                lastReturnedItemFromIterator = previousItem;

                return previousItem.element;
            }

            if (currentItemInIterator.prevItem == null)
                throw new NoSuchElementException();

            Item<T> prevItem = currentItemInIterator.prevItem;
            index--;
            nextCalled = false;

            currentItemInIterator = prevItem;
            lastReturnedItemFromIterator = prevItem;

            return prevItem.element;
            // END
        }

        @Override
        public void add(final T element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(final T element) {
            // BEGIN (write your solution here)

            // END
        }

        @Override
        public int previousIndex() {
            // BEGIN (write your solution here)
            return 0;
            // END
        }

        @Override
        public int nextIndex() {
            // BEGIN (write your solution here)
            return 0;
            // END
        }

        @Override
        public void remove() {
            // BEGIN (write your solution here)
            if (nextCalled == null)
                throw new IllegalStateException();

            if (lastReturnedItemFromIterator.nextItem != null)
                lastReturnedItemFromIterator.nextItem.prevItem = lastReturnedItemFromIterator.prevItem;

            if (lastReturnedItemFromIterator.prevItem != null)
                lastReturnedItemFromIterator.prevItem.nextItem = lastReturnedItemFromIterator.nextItem;

            lastReturnedItemFromIterator.nextItem = null;
            lastReturnedItemFromIterator.prevItem = null;
            lastReturnedItemFromIterator = null;
            if (nextCalled) {
                index--;
            }
            nextCalled = null;
            size--;
            // END
        }
    }

    private static class Item<T> {

        private T element;

        private Item<T> nextItem;

        private Item<T> prevItem;

        Item(final T element, final Item<T> prevItem, final Item<T> nextItem) {
            this.element = element;
            this.nextItem = nextItem;
            this.prevItem = prevItem;
        }


        public Item<T> getNextItem() {
            return nextItem;
        }

        public Item<T> getPrevItem() {
            return prevItem;
        }
    }
}
