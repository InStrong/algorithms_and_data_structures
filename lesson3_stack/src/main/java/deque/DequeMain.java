package deque;

public class DequeMain {

    public static void main(String[] args) {
        Deque<Integer> deque = new DequeImplementation<>(5);
        insertRight(deque,1);  // 1
        insertRight(deque,4);  // 1 4
        insertLeft(deque,5);   // 5 1 4
        insertRight(deque,3);  // 5 1 4 3
        removeLeft(deque);           // 1 4 3
        insertLeft(deque,666); // 666 1 4 3
        removeRight(deque);          // 666 1 4

        while (!deque.isEmpty()){
            System.out.println(removeLeft(deque));
        }

    }

    private static <E> void insertLeft(Deque<E> deque, E value) {
        if (!deque.isFull()){
            deque.insertLeft(value);
        }
    }

    private static <E> void insertRight(Deque<E> deque, E value) {
        if (!deque.isFull()){
            deque.insertRight(value);
        }
    }

    private static <E> E removeLeft(Deque<E> deque) {
        if (!deque.isEmpty()){
            return deque.removeLeft();
        }
        return null;
    }

    private static <E> E removeRight(Deque<E> deque) {
        if (!deque.isEmpty()){
            return deque.removeRight();
        }
        return null;
    }
}
