import java.util.ArrayList;

public class Inversion {
    public static void main(String args[]) {
        int[] arr = { 3, 2, 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A));
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        // if(i<j&&A[i]>A[j])
        int count = 0;
        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            for (int j = i + 1; j < len; j++) {
                int currJ = A.get(j);
                if (currI > currJ) {
                    count++;
                }
            }
        }
        return count;
    }
}
