public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(12));
    }

    private static int factorial(int number){

        return number<=1 ? number : number*factorial(number-1);

    }
}
