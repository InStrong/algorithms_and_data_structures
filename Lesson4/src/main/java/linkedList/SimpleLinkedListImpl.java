package linkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Entry<E> firstElement;
    protected int currentSize;


    public void insert(E value) {
        Entry<E> newElement = new Entry<>(value);
        newElement.setNext(firstElement);
        firstElement = newElement;
        currentSize++;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }
        Entry<E> removedElement = firstElement;
        firstElement = firstElement.getNext();
        currentSize--;
        return removedElement.getValue();

    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public int getSize() {
        return currentSize;
    }

    public boolean find(E value) {

        Entry<E> current = firstElement;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void display() {

        System.out.println("----------");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = firstElement;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();

        }
        System.out.println("----------");

    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = firstElement;
        Entry<E> previous = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                break;
            }
            previous = current;
            current = current.getNext();
        }
        if( current == null){
            return false;
        }

        if (current == firstElement){
            firstElement = firstElement.getNext();
        }

        else {
            previous.setNext(current.getNext());
        }


        currentSize--;
            return false;

    }

    @Override
    public E getFirstElement() {
        return firstElement.getValue();
    }

    @Override
    public Entry<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator<E> implements Iterator<E> {

        private Entry<E> current;

        public MyLinkedListIterator() {
            this.current = (Entry<E>) SimpleLinkedListImpl.this.firstElement;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.getValue();
            current = current.getNext();
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    @Override
    public void forEach(Consumer<? super E> action) {


    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
}
