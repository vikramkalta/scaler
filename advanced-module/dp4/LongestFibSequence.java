import java.util.HashMap;

public class LongestFibSequence {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5};
        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        HashMap<Integer, Integer> intIndexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            intIndexMap.put(arr[i], i);
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = 2;
            }
        }
        int max = 2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int x = arr[i] + arr[j];
                if (intIndexMap.containsKey(x)) {
                    int index = intIndexMap.get(x);
                    int y = dp[i][j] + 1;
                    dp[j][index] = y;
                    if (y > max) {
                        max = y;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.println(dp[i][j] + " i: " + i + " j: " + j);
            }
        }
        return max == 2 ? 0 : max;
    }
}
