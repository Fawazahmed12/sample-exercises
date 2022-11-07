package Arrays;

import java.util.Arrays;

public class Example03 {
    public static void main(String[] args) {
        int[] numbers1 = new int[3];
        Arrays.fill(numbers1, 1);

        int[] number2 = {0,0,0};
        boolean comparision = Arrays.equals(numbers1, number2);
        System.out.println(comparision);

        int[] number3 = {1,1,1};
        comparision = Arrays.equals(numbers1, number3);
        System.out.println(comparision);

        int[] number4 = {1,1};
        comparision = Arrays.equals(numbers1, number4);
        System.out.println(comparision);
    }
}
