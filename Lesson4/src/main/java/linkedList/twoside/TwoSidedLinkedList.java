package linkedList.twoside;

import linkedList.LinkedList;

public interface TwoSidedLinkedList<E> extends LinkedList<E> {

    void insetLeft(E value);
    void insertRight(E value);

    E removeLeft();




}
