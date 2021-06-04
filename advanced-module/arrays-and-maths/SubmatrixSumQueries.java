import java.util.ArrayList;

public class SubmatrixSumQueries {
    public static void main(String args[]) {
        // int[][] arr = { { 1, 1 }, { 1, 1 } };
        // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] arr = {{5, 17, 100, 11}, {0, 0, 2, 8}};
        // int[][] arr = { { 1, 1, 1 }, { 1,1,1 }, { 1,1,1 } };
        // int[][] arr = { { 1, 2, 3,4 }, { 5,6,7,8 }, { 9,10,11,12 }, {13,14,15,16} };
        // int[][] arr = { { 8, 9, 9, 1, 7 }, { 5, 5, 10, 1, 0 }, { 7, 7, 5, 8, 6 }, { 7, 3, 7, 9, 2 },
        //         { 7, 7, 8, 10, 6 } };
        ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] curr = arr[i];
            ArrayList<Integer> innerA = new ArrayList<>();
            for (int j = 0; j < curr.length; j++) {
                innerA.add(curr[j]);
            }
            main.add(innerA);
        }
        // int[] a = {1,2}, b = {1,2}, c = {2,3}, d = {2,3};
        int[] a = {1,1}, b = {1,4}, c = {2,2}, d = {2,4};
        // int[] a = {2,3}, b = {2,3}, c = {3,3}, d = {3,3};
        ArrayList<Integer> A = new ArrayList<>(), B = new ArrayList<>(), C = new ArrayList<>(), D = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            A.add(a[i]);
            B.add(b[i]);
            C.add(c[i]);
            D.add(d[i]);
        }
        System.out.println(submatrixSumQueries(main,A,B,C,D));
    }

    public static ArrayList<Integer> submatrixSumQueries(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int row = A.size();

        int sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < row; i++) {
            int curr = A.get(i).get(0);
            // sum += curr;
            sum = (sum + curr) % mod;
            if (sum < 0) sum += mod;
            A.get(i).set(0, sum);
        }

        int col = A.get(0).size();
        sum = 0;
        for (int i = 0; i < col; i++) {
            int curr = A.get(0).get(i);
            // sum += curr;
            sum = (sum + curr) % mod;
            if (sum < 0) sum += mod;
            A.get(0).set(i, sum);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int curr = A.get(i).get(j);
                int top = A.get(i - 1).get(j);
                int left = A.get(i).get(j - 1);
                int topLeft = A.get(i - 1).get(j - 1);
                int x = (top + left + curr - topLeft) % mod;
                if (x < 0) x += mod;
                A.get(i).set(j, x);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int queryLen = B.size();
        for (int i = 0; i < queryLen; i++) {
            int b = B.get(i) - 1;
            int c = C.get(i) - 1;
            int d = D.get(i) - 1;
            int e = E.get(i) - 1;
            int bottomRightSum = A.get(d).get(e);
            int bottomLeftSum = 0,topRightSum = 0,topLeftSum = 0;
            if (b-1>=0) {
                topRightSum = A.get(b-1).get(e);
            }
            if (c-1>=0) {
                bottomLeftSum = A.get(d).get(c-1);
            }
            if (b-1>=0&&c-1>=0) {
                topLeftSum = A.get(b-1).get(c-1);
            }
            
            int finalSum = (bottomRightSum - bottomLeftSum - topRightSum + topLeftSum) % mod;
            if (finalSum < 0) finalSum += mod;
            result.add(finalSum);
        }

        return result;
    }
}
