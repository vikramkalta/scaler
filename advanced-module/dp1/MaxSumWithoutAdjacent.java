import java.util.ArrayList;

public class MaxSumWithoutAdjacent {
    public static void main(String args[]) {
        // int[][] a = {{1, 2, 3, 4},{2, 3, 4, 5}};
        // int[][] a = {
        //     {74, 37, 82, 1},
        //     {66, 38, 16, 1}};
        int[][] a = {
            {2, 6, 6, 1, 16, 6, 15},
            {9, 16, 5, 4, 20, 3, 3}
        };
        // int[][] a = { { 1, 2, 3, 4 }, { 5,6,7,8 }, { 16, 15, 14,13 }, { 12,11,10,9 } };
        // int[][] a = {{14, 87, 36, 23}, {37, 59, 21, 68}};
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                innerArr.add(a[i][j]);
            }
            A.add(innerArr);
        }
        System.out.println(adjacent(A));
    }

    public static int adjacent(ArrayList<ArrayList<Integer>> A) {
        int len = A.get(0).size();
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            dp.add(-1);
        }
        // int maxSum = Integer.MIN_VALUE;

        dp.set(0, Math.max(A.get(0).get(0), A.get(1).get(0)));
        if (len==1) {
            return dp.get(0);
        }
        int x = Math.max(A.get(0).get(1), A.get(1).get(1));
        dp.set(1, Math.max(dp.get(0), x));
        int maxSum = dp.get(1);

        for (int i = 2; i < len; i++) {
            int max = Math.max(A.get(0).get(i), A.get(1).get(i));
            int prevAns = dp.get(i-2);
            int sum = max + prevAns;
            int y = Math.max(dp.get(i-1), sum);
            // if (maxSum < sum) {
            //     maxSum = sum;
            // }
            dp.set(i, y);
        }

        return dp.get(len-1);
    }

    public static int adjacent1(ArrayList<ArrayList<Integer>> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int innerLen = A.get(i).size();
            int totalSum = 0;
            int parentSum = 0;
            for (int j = 0; j < innerLen; j += 2) {
                int curr = A.get(i).get(j);
                parentSum += curr;
            }

            for (int j = i + 2; j < len; j+=2) {
                for (int k = 0; k < innerLen; k += 2) {
                    int curr = A.get(j).get(k);
                    totalSum += curr;
                }
            }
            int sumOdd = parentSum + totalSum;
            if (max < sumOdd) {
                max = sumOdd;
            }

            totalSum = 0; // Reset before calculating odd
            for (int j = i + 2; j < len; j+=2) {
                for (int k = 1; k < innerLen; k+=2) {
                    int curr = A.get(j).get(k);
                    totalSum += curr;
                }
            }
            int sumEven = parentSum + totalSum;
            if (max < sumEven) {
                max = sumEven;
            }
        }

        for (int i = 0; i < len; i++) {
            int innerLen = A.get(i).size();
            int totalSum = 0;
            int parentSum = 0;
            for (int j = 1; j < innerLen; j += 2) {
                int curr = A.get(i).get(j);
                parentSum += curr;
            }

            for (int j = i + 2; j < len; j+=2) {
                for (int k = 0; k < innerLen; k += 2) {
                    int curr = A.get(j).get(k);
                    totalSum+=curr;
                }
            }
        
            int sumOdd = parentSum + totalSum;
            if (max < sumOdd) {
                max = sumOdd;
            }

            totalSum = 0; // Reset before calculating odd
            for (int j = i + 2; j < len; j+=2) {
                for (int k = 1; k < innerLen; k+=2) {
                    int curr = A.get(j).get(k);
                    totalSum += curr;
                }
            }
            int sumEven = parentSum + totalSum;
            if (max < sumEven) {
                max = sumEven;
            }
        }

        return max;
    }
}
