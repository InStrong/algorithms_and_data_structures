package homework;

public class Exponentiation {


    public static double pow(int number, int exponent) {

        if (exponent == 0) return 1;

        return exponent>0 ? number*pow(number,exponent-1) :
                1 / (number * pow(number, -1*exponent - 1));

    }


    public static void main(String[] args) {
        System.out.println( pow(5,-4));
        System.out.println( pow(2,0));
        System.out.println( pow(0,4));
        System.out.println( pow(2,5));
    }
}
