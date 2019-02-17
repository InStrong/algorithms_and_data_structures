import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        Array array = new Array(100000);
        array.fillWithRandomNumbers();

        Array arr1=new Array(array.array.length);
        Array arr2=new Array(array.array.length);
        Array arr3=new Array(array.array.length);

        for (int i = 0; i < array.array.length; i++) {
            arr1.add(array.get(i));
            arr2.add(array.get(i));
            arr3.add(array.get(i));
        }
        long bubble,select,insert;

        bubble=System.currentTimeMillis();
        arr1.sortBubble();
        System.out.println("Bubble time : " + (System.currentTimeMillis()-bubble));

        select=System.currentTimeMillis();
        arr2.sortSelect();
        System.out.println("Select time : " + (System.currentTimeMillis()-select));


        insert=System.currentTimeMillis();
        arr3.sortInsert();
        System.out.println("Insert time : " + (System.currentTimeMillis()-insert));




    }
}
