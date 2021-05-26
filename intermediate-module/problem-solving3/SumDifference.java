import java.util.ArrayList;
import java.util.Collections;

public class SumDifference {
    static ArrayList<ArrayList<Integer>> subsequences = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> sumDiff = new ArrayList<>();
    // static int sum = 0;

    public static void main(String args[]) {
        // int[] arr = {1,2,3};
        // int[] arr = { 1, 2 };
        // int[] arr = {2, 5, 1};
        // int[] arr = {1,2,3,4,5};
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) arr[i]=i+1;
        // int[] arr = {5, 4, 2};
        // int[] arr = {5, 4, 3, 2};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(sumDiff(A));
        // System.out.println(subsequences);
    }

    public static int sumDiff(ArrayList<Integer> A) {
        int len = A.size();
        Collections.sort(A);
        long maxSum = 0;
        long minSum = 0;
        long mod = 1000000007l;

        ArrayList<Long> powers = new ArrayList<>();
        long first = 1;
        powers.add(first);

        for (int i = 1; i < len; i++) {
            long prev = powers.get(i - 1);
            long curr = (prev * 2) % mod;
            powers.add(curr);
        }

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            long powerValMin = powers.get(len - 1 - i);
            long productMin = (curr * powerValMin) % mod;
            minSum %= mod;
            minSum = (minSum + productMin) % mod;

            long powerValMax = powers.get(i);
            long productMax = (curr * powerValMax) % mod;
            maxSum %= mod;
            maxSum = (maxSum + productMax) % mod;
        }
        long c = maxSum - minSum;
        c += mod;
        return (int)(c % mod);
    }

    public static long getPowerValue(int n) {
        return 1 << n;
    }

    public static int sumDiff1(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<>();

        ArrayList<Integer> sum = new ArrayList<>();
        // sum.add(0);
        // getSubsequences(A, temp, sum);

        return sum.get(0);
    }

    public static void getSubsequences(ArrayList<Integer> A, ArrayList<Integer> temp, ArrayList<Integer> sum) {
        int len = A.size();
        if (len == 0) {
            int _len = temp.size();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            if (_len > 1) {
                for (int i = 0; i < _len; i++) {
                    int curr = temp.get(i);
                    if (max < curr) {
                        max = curr;
                    }
                    if (min > curr) {
                        min = curr;
                    }
                }
                int _sum = sum.get(0);
                _sum = _sum + (max - min);
                sum.set(0, _sum);
            }

            subsequences.add(temp);
            return;
        }

        ArrayList<Integer> newA = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            newA.add(A.get(i));
        }

        int firstElement = A.get(0);

        ArrayList<Integer> newTemp = new ArrayList<>();

        int tempLen = temp.size();

        for (int i = 0; i < tempLen; i++) {
            newTemp.add(temp.get(i));
        }

        newTemp.add(firstElement);

        getSubsequences(newA, newTemp, sum);

        getSubsequences(newA, temp, sum);
    }
}
