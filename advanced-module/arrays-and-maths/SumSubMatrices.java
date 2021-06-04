import java.util.ArrayList;

public class SumSubMatrices {
    public static void main(String args[]) {
        // int[][] arr = { { 1, 1 }, { 1, 1 } };
        // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int[][] arr = { { 1, 1, 1 }, { 1,1,1 }, { 1,1,1 } };
        // int[][] arr = { { 1, 2, 3,4 }, { 5,6,7,8 }, { 9,10,11,12 }, {13,14,15,16} };
        int[][] arr = { { 8, 9, 9, 1, 7 }, { 5, 5, 10, 1, 0 }, { 7, 7, 5, 8, 6 }, { 7, 3, 7, 9, 2 },
                { 7, 7, 8, 10, 6 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] curr = arr[i];
            ArrayList<Integer> innerA = new ArrayList<>();
            for (int j = 0; j < curr.length; j++) {
                innerA.add(curr[j]);
            }
            A.add(innerA);
        }
        System.out.println(sumSubMatrices(A));
    }

    public static int sumSubMatrices(ArrayList<ArrayList<Integer>> A) {
        int len = A.size();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int curr = A.get(i).get(j);
                int topLeft = (i + 1) * (j + 1);
                int bottomRight = (len - i) * (len - j);
                sum += curr * (topLeft * bottomRight);
            }
        }
        return sum;
    }

    // public static int sumSubMatrices(ArrayList<ArrayList<Integer>> A) {
    // int len = A.size();
    // int sum = 0;
    // int occurrence = getOccurrence(len);
    // occurrence = len % 2 == 0 ? occurrence : (occurrence + 1);
    // int len0 = len - 1;
    // // System.out.println("occurrence"+occurrence);
    // for (int i = 0; i < len; i++) {
    // for (int j = 0; j < len; j++) {
    // int curr = A.get(i).get(j);
    // if ((i == 0 && j == 0)
    // || (i == 0 && j == len0)
    // || (i == len0 && j == 0)
    // || (i == len0 && j == len0)) {
    // sum += (curr * occurrence);
    // } else if (i == 0 || j == 0 || i == len0 || j == len0) {
    // int x = getOccurrence(len - 1);
    // int y = len % 2 == 0 ? x : (x-1);
    // y += occurrence;
    // sum += (curr * y);
    // } else {
    // int x = (occurrence * 2) - 2;
    // sum += (curr * x);
    // }
    // }
    // }
    // return sum;
    // }

    public static int sumSubMatrices1(ArrayList<ArrayList<Integer>> A) {
        int len = A.size();
        int sum = 0;
        int occurrence = getOccurrence(len);
        // System.out.println("occurrence"+occurrence);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int curr = A.get(i).get(j);
                int prod = curr * occurrence;
                // System.out.println("curr: " + curr + " prod: " + prod);
                sum += prod;
            }
        }
        return sum;
    }

    private static int getOccurrence(int A) {
        return 1 << A;
        // if (A % 2 == 0) {
        // return 1 << A;
        // } else {
        // int ans = 1 << A;
        // ans++;
        // return ans;
        // }
    }
}
