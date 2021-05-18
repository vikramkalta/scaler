import java.util.ArrayList;

public class Bulbs {
    public static void main(String args[]) {
        // int[] arr = { 0, 1, 0, 1 };
        int[] arr = { 1, 1, 1, 1 };
        
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(turnOnBulbs(A));
    }

    public static int turnOnBulbs(ArrayList<Integer> A) {
        int len = A.size();

        int counter = 0;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr == 0 && counter % 2 == 0) {
                counter++;
            }
            if (curr == 1 && counter % 2 != 0) {
                counter++;
            }
        }

        return counter;
    }
}
