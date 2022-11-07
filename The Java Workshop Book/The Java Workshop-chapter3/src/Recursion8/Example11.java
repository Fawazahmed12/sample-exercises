package Recursion8;

public class Example11 {
    public static long fact (int n ) {
        if ( n == 1 )
            return 1;
        else
            return n * fact (n -1 );
    }

    public static void main(String[] args) {
        int input = Integer.parseInt(args[0]);
        long factorial = fact(input);
        System.out.println(factorial);
    }
}
