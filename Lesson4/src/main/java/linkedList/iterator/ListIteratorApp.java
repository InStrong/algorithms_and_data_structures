package linkedList.iterator;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorApp {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        ListIterator listite = list.listIterator();
        while (listite.hasNext()){
            System.out.print(listite.next()+" ");
        }
        System.out.println("\n--------------");


        while (listite.hasPrevious()){
            System.out.print(listite.previous()+" ");
            System.out.print(listite.nextIndex()+" ");
            System.out.println(listite.previousIndex());
        }
        System.out.println("\n--------------");
        while(listite.hasPrevious()){

            System.out.print(listite.previous()+" ");
        }
        System.out.println("\n--------------");
        while (listite.hasNext()) {
            System.out.println(listite.next());
        }
        listite.set(666);
        System.out.println("After set : ");
        for (Integer item : list) {
            System.out.println(item);
        }
    }


}
