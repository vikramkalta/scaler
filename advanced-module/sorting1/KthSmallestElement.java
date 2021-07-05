import java.util.ArrayList;

public class KthSmallestElement {
    public static void main(String args[]) {
        // int[] arr = { 2, 1, 4, 3, 2 };
        int[] arr = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91,
                36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        // int[] arr = { 5, 10, 20 };
        // int[] arr = { 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 3));
        System.out.println(solve(A, 9));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < len; i++)
            a.add(A.get(i));
        int start = 0;
        while (start < B) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = start; i < len; i++) {
                int curr = a.get(i);
                if (min > curr) {
                    min = curr;
                    minIndex = i;
                }
            }
            int temp = a.get(start);
            a.set(start, min);
            a.set(minIndex, temp);
            start++;
        }
        return a.get(B - 1);
    }
}
