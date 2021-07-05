import java.util.ArrayList;

public class SubarrayGivenSum {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 5, 10, 20, 100, 105 };
        // int[] arr = { 42, 9, 38, 36, 48, 33, 36, 50, 38, 8, 13, 37, 33, 38, 17, 25,
        // 50, 50, 41, 29, 34, 18, 16, 6, 49,
        // 16, 21, 29, 41, 7, 37, 14, 5, 30, 35, 26, 38, 35, 9, 36, 34, 39, 9, 4, 41,
        // 40, 3, 50, 27, 17, 14, 5, 31,
        // 42, 5, 39, 38, 38, 47, 24, 41, 5, 50, 9, 29, 14, 19, 27, 6, 23, 17, 1, 22,
        // 38, 35, 6, 35, 41, 34, 21,
        // 30, 45, 48, 45, 37 };
        int[] arr = { 12, 1, 50, 39, 32, 23, 22, 44, 17, 5, 9, 12, 10, 50, 26, 5, 23, 38, 31, 5, 34, 8, 21, 11, 24, 44,
                18, 19, 6, 31, 3, 47, 5, 2, 33, 44, 14, 9 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 5));
        // System.out.println(solve(A, 110));
        // System.out.println(solve(A, 100));
        System.out.println(solve(A, 58));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        int start = 0, end = 1;

        int sum = A.get(0);

        boolean isFound = false;
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            sum += curr;
            end++;
            if (sum > B) {
                while (sum > B) {
                    sum = sum - A.get(start);
                    start++;
                    if (sum == B) {
                        isFound = true;
                        break;
                    }
                }
            }
            if (sum == B) {
                isFound = true;
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (!isFound) {
            result.add(-1);
            return result;
        }
        for (int i = start; i < end; i++) {
            result.add(A.get(i));
        }
        return result;
    }
}
