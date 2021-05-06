import java.util.ArrayList;

public class OddEvenSum {
    public static void main(String args[]) {
        // int[] arr = { 2, 1, 6, 4 };
        int[] arr = { 1,1,1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(oddEvenSum(A));
    }

    public static int oddEvenSum(ArrayList<Integer> A) {
        int len = A.size();

        int countOfEqualSum = 0;
        int sumOfOdds = 0;
        int sumOfEvens = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int curr = A.get(j);
                    int mod = 0;
                    if (j > i) {
                        mod = (j - 1);
                    } else {
                        mod = j;
                    }
                    if (mod % 2 == 0) {
                        sumOfEvens = sumOfEvens + curr;
                    } else {
                        sumOfOdds = sumOfOdds + curr;
                    }
                }
            }
            if (sumOfEvens == sumOfOdds) {
                countOfEqualSum++;
            }
            sumOfEvens = 0;
            sumOfOdds = 0;
        }

        return countOfEqualSum;
    }
}
