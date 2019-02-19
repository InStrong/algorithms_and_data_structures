package deque;

public class DequeImplementation<E> implements Deque<E> {

    public static final int DEFAULT_TAIL = -1;
    public static final int DEFAULT_HEAD = 0;
    protected E[] data;
    protected int size;

    private int head;
    private int tail;

    public DequeImplementation(int maxSize) {
        this.data = (E[]) new Object[maxSize];
        this.size = 0;
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    @Override
    public void insertLeft(E value) {
        if (head == 0) {
            head = data.length;
        }

        data[--head] = value;

        size++;

    }

    @Override
    public void insertRight(E value) {
        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
    }

    @Override
    public E removeLeft() {
        E value = data[head++];
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        E value = data[tail--];
        if (tail == data.length) {
            tail = DEFAULT_TAIL;
        }
        size--;
        return value;
    }

    @Override
    public void insert(E value) {
        insertRight(value);
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peek() {
        return data[head];
    }

    @Override
    public E peekHead() {
        return data[head];
    }

    @Override
    public E peekTail() {
        return data[tail];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
