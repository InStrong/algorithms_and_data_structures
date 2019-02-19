package queue;

public class PriorityQueue<E extends Object & Comparable<? super E>> extends QueueImplementation<E> {

    @Override
    public E remove() {
        return data[--size];
    }

    public PriorityQueue(int maxSize) {
        super(maxSize);
        this.data = (E[]) new Object[maxSize];
    }

    @Override
    public E peek() {
        return data[size - 1];
    }

    @Override
    public void insert(E value) {
        if (isEmpty()) {
            data[size++] = value;
            return;
        }

        int index;
        for (index = size - 1; index >= 0; index--) {
            if (value.compareTo(data[index])>0) {
                data[index + 1] = data[index];
            }
            else{
                break;
            }
        }
        data[index+1] = value;
        size++;
    }
}
