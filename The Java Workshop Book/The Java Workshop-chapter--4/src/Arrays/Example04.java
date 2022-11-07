package Arrays;

import java.util.Arrays;

public class Example04 {
    public static void main(String[] args) {
        String[]  text = {"love", "is", "in", "the", "air"};

        Arrays.sort(text);
        System.out.println(Arrays.toString((text)));

        int search = Arrays.binarySearch(text, "the");  /// output will come based on  index
        System.out.println(search);
    }
}
