import java.util.ArrayList;

public class Sixlets {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3 };
        int[]arr={1, 2, 8};
        // int[] arr = { 1, 2, 1000 };
        // int[] arr= {5, 17, 1000, 11};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 3));
        System.out.println(solve(A, 2));
        // System.out.println(solve(A, 4));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            arr.add(0);
        }
        int x = generateSubsequences(arr, 0, B, A, len);
        return x;
    }

    private static int generateSubsequences(ArrayList<Integer> A, int index, int B, ArrayList<Integer> originalArr, int len) {
        if (index == len) {
            int sum = 0;
            int subsequenceLength = A.size();
            int count = 0;
            for (int i = 0; i < subsequenceLength; i++) {
                int curr = A.get(i);
                if (curr == 1) {
                    sum += originalArr.get(i);
                    count++;
                }
                if (sum > 1000) {
                    return 0;
                }
                if (count > B) {
                    return 0;
                }
            }
            if (count == B) {
                return 1;
            }else{
                return 0;
            }
        }
        A.set(index, 0);
        int x = generateSubsequences(A, index + 1, B, originalArr, len);
        A.set(index, 1);
        int y = generateSubsequences(A, index + 1, B, originalArr, len);
        return x + y;
    }
}