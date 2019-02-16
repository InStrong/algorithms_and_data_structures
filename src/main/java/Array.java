import java.util.Arrays;

public class Array {

    public static final Integer DEFAULT_CAPACITY=32;
    protected Integer[] array;
    protected int currentSize;

    public Array(Integer capacity) {
        this.array = new Integer[capacity];
    }

    public Array() {
        this.array = new Integer[DEFAULT_CAPACITY];
    }

    protected void info(){
        System.out.println(Arrays.toString(array));
    }

    public Integer getSize(){
        return currentSize;
    }

    public boolean inEmpty(){
        return currentSize==0;
    }

    public void add(Integer value){
        checkIfNeedToGrow();
        this.array[currentSize++] = value;
    }

    protected void checkIfNeedToGrow() {
        if(currentSize<array.length) return;

        array = Arrays.copyOf(array,array.length*2);
    }

    public Integer get(Integer index){
        return array[index];
    }

    public boolean contains(Integer value){
        return indexOf(value) != -1;
    }

    public Integer indexOf(Integer value){
        for (Integer i = 0; i < currentSize; i++) {
            if(array[i]==value) return i;
        }

        return -1;
    }

    public boolean removeByIndex(Integer index){
        if (index==-1)
            return false;

        for (Integer i = index; i < currentSize-1; i++) {

            array[i]=array[i+1];
        }

        array[currentSize-1]=null;
        currentSize--;

        return false;
    }

    public boolean remove(Integer value){
        return removeByIndex(value);
    }


    public void fillWithRandomNumbers(){
        for (int i = 0; i < array.length; i++) {
            array[i]=(int) (Math.random()*100);
        }
    }


    public void sortBubble(){

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j]>array[j+1]) swap(j,j+1);
            }
        }

    }

    public void sortSelect(){

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length ; j++) {
                if (array[j]<array[minIndex]) {
                    minIndex=j;
                }
            }
            swap(minIndex,i);
        }

    }

    public void sortInsert(){

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int in=i;
            while(in>0 && array[in-1]>=temp){
                array[in]=array[in-1];
                in--;
            }
            array[in]=temp;
        }

    }

    private void swap(int index1,int index2){
        int temp = array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
}
