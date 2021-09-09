import java.util.ArrayList;

public class NumberOfSquareful {
    public static void main(String args[]) {
        // int[] arr = {1,2,3};
        // int[]arr={2, 2, 2};
        int[]arr={1,17,8};
        // int[]arr={2, 2, 3};
        ArrayList<Integer>A=new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            A.add(arr[i]);
        }
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer>A) {
        int count = generatePermutations(A, 0, A.size(), 0);
        return count;
    }

    public static int generatePermutations(ArrayList<Integer> A, int index, int len, int count) {
        if (index == len) {
            System.out.println("A: "+A);
            int curr = A.get(0);
            for (int i = 1; i < len; i++) {
                int next = A.get(i);
                int sum = curr+ next;
                int x = (int)Math.sqrt(sum);
                if (x*x != sum) {
                    return 0;
                }
                curr = next;
            }
            return 1;
        }

        for (int i = index; i < len; i++) {
            // int currIndex = A.get(index);
            // int currI = A.get(i);
            if (shouldSwap(A, i, index)) {
                swap(A, index, i);
                count = count + generatePermutations(A, index + 1, len, 0);
                swap(A, index, i);
            }
        }
        return count;
    }

    private static ArrayList<Integer> swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
        return A;
    }

    private static boolean shouldSwap(ArrayList<Integer> A, int i, int j) {
        if (A.get(i) == A.get(j)) {
            return false;
        }
        return true;
    }
}
