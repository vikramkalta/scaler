import java.util.ArrayList;

public class FreeCars {
    public static void main(String args[]) {
        // int[] a = { 1, 3, 2, 3, 3 };
        // int[] b = { 5, 6, 1, 3, 9 };
        // int[] a = {3, 8, 7, 5};
        // int[] b= {3, 1, 7, 19};
        int[] a = {1, 7, 6, 2, 8, 4, 4, 6, 8, 2};
        // 1, 7, 6, 2, 8, 4, 4, 6, 8, 2
        int[] b= {8, 11, 7, 7, 10, 8, 7, 5, 4, 9};
        // 8, 11, 7, 7, 10, 8, 7, 5, 4, 9
        // int[]a={4, 5, 3};
        // int[]b={3, 7, 4};
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
            B.add(b[i]);
        }
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();

        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (maxTime < curr) {
                maxTime = curr;
            }
        }

        long mod = 1000000007l;
        merge(A, B, 0, len - 1);
        for (int i = 0; i < len / 2; i++) {
            int currTime = A.get(i);
            A.set(i, A.get(len - 1 - i));
            A.set(len - 1 - i, currTime);
            int currProfit = B.get(i);
            B.set(i, B.get(len - 1 - i));
            B.set(len - 1 - i, currProfit);
        }

        int maxLen = Math.max(len, maxTime);
        ArrayList<Long> carPositions = new ArrayList<>();
        for (int i = 0; i < maxLen; i++) {
            carPositions.add(-1l);
        }
        for (int i = 0; i < len; i++) {
            long currProfit = B.get(i) * 1l;
            int currTime = A.get(i);
            if (carPositions.get(currTime - 1) == -1) {
                carPositions.set(currTime - 1, currProfit);
            } else {
                int j = currTime - 2;
                while (j >= 0) {
                    if (carPositions.get(j) == -1) {
                        carPositions.set(j, currProfit);
                        break;
                    }
                    j--;
                }
            }
        }
        long profit = 0l;
        for (int i = 0; i < maxLen; i++) {
            long currProfit = carPositions.get(i);
            if (currProfit != -1l) {
                profit += currProfit;
            }
        }

        return (int) (profit % mod);
    }

    public static void merge(ArrayList<Integer> A, ArrayList<Integer> B, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        merge(A, B, l, m);
        merge(A, B, m + 1, r);
        mergeSort(A, B, l, m, r);
    }

    public static void mergeSort(ArrayList<Integer> A, ArrayList<Integer> B, int l, int m, int r) {
        ArrayList<Integer> timeListLeft = new ArrayList<>();
        ArrayList<Integer> timeListRight = new ArrayList<>();
        ArrayList<Integer> profitListLeft = new ArrayList<>();
        ArrayList<Integer> profitListRight = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            timeListLeft.add(A.get(i));
            profitListLeft.add(B.get(i));
        }
        for (int i = m + 1; i <= r; i++) {
            timeListRight.add(A.get(i));
            profitListRight.add(B.get(i));
        }
        int lenLeft = timeListLeft.size();
        int lenRight = timeListRight.size();
        int i = 0, j = 0, k = l;
        while (i < lenLeft && j < lenRight) {
            int currTimeLeft = timeListLeft.get(i);
            int currTimeRight = timeListRight.get(j);
            int currProfitLeft = profitListLeft.get(i);
            int currProfitRight = profitListRight.get(j);
            if (currProfitLeft < currProfitRight) {
                B.set(k, currProfitLeft);
                A.set(k, currTimeLeft);
                i++;
            } else {
                B.set(k, currProfitRight);
                A.set(k, currTimeRight);
                j++;
            }
            k++;
        }
        while (i < lenLeft) {
            B.set(k, profitListLeft.get(i));
            A.set(k, timeListLeft.get(i));
            i++;
            k++;
        }
        while (j < lenRight) {
            B.set(k, profitListRight.get(j));
            A.set(k, timeListRight.get(j));
            j++;
            k++;
        }
    }
}
