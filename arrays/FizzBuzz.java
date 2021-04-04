import java.util.ArrayList;

public class FizzBuzz {
    public static void main(String args[]) {
        System.out.println(getResult(3));
    }

    public static ArrayList<String> getResult(int A) {
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                arr.add("FizzBuzz");
            } else if (i % 3 == 0) {
                arr.add("Fizz");
            } else if (i % 5 == 0) {
                arr.add("Buzz");
            } else {
                arr.add(String.valueOf(i));
            }
        }
        return arr;
    }
}
