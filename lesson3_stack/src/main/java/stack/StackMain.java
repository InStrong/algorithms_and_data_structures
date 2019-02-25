package stack;

import queue.Queue;

public class StackMain {

    public static void main(String[] args) {
        Stack<Integer> stack = new StackImplementation<>(5);
        insert(stack,2);
        insert(stack,1);
        insert(stack,4);
        insert(stack,5);
        insert(stack,3);
        insert(stack,666);

        System.out.println("Size: " +stack.size());
        System.out.println("Peek: " +stack.peek());

        System.out.println("Remove last: " +remove(stack));
        System.out.println("Size: "+stack.size());
        System.out.println("Peek: "+stack.peek());

//        while (!stack.isEmpty()){
//            System.out.println(remove(stack));
//        }
    }

    private static <E> E remove(Stack<E> stack) {
        if (!stack.isEmpty()){
            return stack.pop();
        }
        return null;
    }

    private static <E> void insert(Stack<E> stack, E value) {
        if (!stack.isFull()){
            stack.push(value);
        }
    }

}
