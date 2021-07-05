import java.util.ArrayList;

public class PairsGivenSum {
    public static void main(String args[]) {
        // int[] arr = { 1, 1, 1 };
        // int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr = { 1, 2, 3, 3, 3, 4, 5 };
        // int[] arr = { 1, 2, 3, 3, 4, 5 };
        // int[] arr = { 1, 2, 6, 6, 7, 9, 9 };
        // int[] arr = { 2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10 };
        // int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 9, 10 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 2));
        System.out.println(solve(A, 6));
        // System.out.println(solve(A, 13));
        // System.out.println(solve(A, 11));
        // System.out.println(solve(A, 5));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int mod = 1000000007;
        int len = A.size();
        int start = 0, end = len - 1;
        long count = 0l;
        while (start < end) {
            int currStart = A.get(start);
            int currEnd = A.get(end);
            long sum = 1l * (currStart + currEnd);
            if (sum > B) {
                end--;
            } else if (sum < B) {
                start++;
            } else {
                if (currStart == currEnd) {
                    long diff = 1l * (end - start + 1);
                    long totalPairs = 1l * (diff * (diff - 1));
                    totalPairs = totalPairs / 2;
                    count = (count + totalPairs) % mod;
                    if (count < 0)
                        count += mod;
                    break;
                } else {
                    long countStart = 0l, countEnd = 0l;
                    while (start < end && A.get(start) == currStart) {
                        countStart++;
                        start++;
                    }
                    while (end >= start && A.get(end) == currEnd) {
                        countEnd++;
                        end--;
                    }
                    long x = (countStart * countEnd) % mod;
                    if (x < 0)
                        x += mod;
                    count = count + x;
                }

                // if (end - 1 > start && A.get(end - 1) == currEnd) {
                // end--;
                // } else if (start + 1 < end && A.get(start + 1) == currStart) {
                // start++;
                // } else {
                // start++;
                // }

            }
        }

        return (int) (count % mod);
    }
}
