import java.util.ArrayList;

public class CountOfDivisors {
    public static void main(String args[]) {
        // int[] arr ={81991, 2549, 7};
        int[] arr ={2, 3, 4, 5};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) A.add(arr[i]);
        System.out.println(divisorCount(A));
    }

    private static ArrayList<Integer> divisorCount(ArrayList<Integer> A) {
        int len = A.size();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int count = 2;
            if (curr == 1) {
                count = 1;
            }
            for (int j = 2; j < curr; j++) {
                if (curr % j == 0) {
                    count++;
                }
            }
            A.set(i, count);
        }

        return A;
    }
}
