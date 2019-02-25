package linkedList;

import stack.Stack;

public class LinkStackImpl<E> implements Stack<E> {

    private LinkedList<E> data;
    public LinkStackImpl(){
        this.data = new SimpleLinkedListImpl<>();
    }

    @Override
    public void push(E value) {
        data.insert(value);
    }

    @Override
    public E pop() {
        return data.remove();
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
