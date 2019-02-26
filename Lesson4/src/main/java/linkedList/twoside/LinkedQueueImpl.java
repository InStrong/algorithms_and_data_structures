package linkedList.twoside;

import linkedList.twoside.TwoSidedLinkedList;
import queue.Queue;

public class LinkedQueueImpl<E> implements Queue<E> {

    private TwoSidedLinkedList<E> data;

    public LinkedQueueImpl() {
        this.data = new TwoSidedLinkedListImpl<>();
    }

    @Override
    public void insert(E value) {
        data.insertRight(value);
    }

    @Override
    public E remove() {
        return data.removeLeft();
    }

    @Override
    public E peek() {
        return data.getFirstElement();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}