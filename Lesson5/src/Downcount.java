public class Downcount {

    private int count;

    public Downcount(int count) {
        this.count = count;
    }

    public void run() {
        while (count > 0) {
            System.out.println(count--);
        }

    }

    public void runRecursion() {

        doRun(count);
    }

    private void doRun(int count) {
        if (count<=0){
            return;
        }
        System.out.println(count);
        doRun(--count);
    }

    public static void main(String[] args) {
        new Downcount(5).runRecursion();
    }
}
