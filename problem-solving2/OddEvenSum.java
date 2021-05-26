import java.util.ArrayList;

public class OddEvenSum {
    public static void main(String args[]) {
        // int[] arr = { 2, 1, 6, 4 };
        int[] arr = { 1, 1, 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(oddEvenSum(A));
    }

    public static int oddEvenSum(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Integer> prefixOddEven = new ArrayList<>();
        int sumOdd = 0, sumEven = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (i % 2 == 0) {
                sumEven += curr;
                prefixOddEven.add(sumEven);
            } else {
                sumOdd += curr;
                prefixOddEven.add(sumOdd);
            }
        }
        int count = 0;
        int _sum2ndLast = prefixOddEven.get(len - 2);
        int _sumLast = prefixOddEven.get(len - 1);
        // 1,2,3,4,5,6
        // 1,2,3,4,5,6,7
        for (int i = 0; i < len; i++) {
            int curr = prefixOddEven.get(i), prev = 0, prevPrev = 0;
            if (i > 0) {
                prev = prefixOddEven.get(i - 1);
            }
            if (i > 1) {
                prevPrev = prefixOddEven.get(i - 2);
            }
            int newOddSum = 0,newEvenSum = 0,mod = i + 1;

            int _sumOdd = 0, _sumEven = 0;
            if (len % 2 == 0) {
                _sumOdd = _sum2ndLast;
                _sumEven = _sumLast;
            } else {
                _sumOdd = _sumLast;
                _sumEven = _sum2ndLast;
            }

            if (mod % 2 != 0) {
                newOddSum = _sumOdd - curr + prev;
                newEvenSum = _sumEven - prev + prevPrev;
            } else {
                newEvenSum = _sumEven - curr + prev;
                newOddSum = _sumOdd - prev + prevPrev;
            }
            if (newOddSum == newEvenSum) {
                count++;
            }
        }

        return count;
    }

    public static int oddEvenSum1(ArrayList<Integer> A) {
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
