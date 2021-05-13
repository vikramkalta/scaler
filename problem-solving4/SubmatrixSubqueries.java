import java.util.ArrayList;
import java.util.Collections;

public class SubmatrixSubqueries {
    public static void main(String args[]) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
        // int arr[][] = { { 5, 17, 100, 11 }, { 0, 0, 2, 8 } };
        // int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> iA = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                iA.add(arr[i][j]);
            }
            A.add(iA);
        }
        int[] arrB = { 1, 2 };
        int[] arrC = { 1, 2 };
        int[] arrD = { 2, 3 };
        int[] arrE = { 2, 3 };
        // int[] arrB = { 1, 1 };
        // int[] arrC = { 1, 4 };
        // int[] arrD = { 2, 2 };
        // int[] arrE = { 2, 4 };
        // int[] arrB = { 3, 2 };
        // int[] arrC = { 3, 1 };
        // int[] arrD = { 4, 4 };
        // int[] arrE = { 4, 2 };
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        ArrayList<Integer> E = new ArrayList<>();
        for (int i = 0; i < arrB.length; i++)
            B.add(arrB[i]);
        for (int i = 0; i < arrC.length; i++)
            C.add(arrC[i]);
        for (int i = 0; i < arrD.length; i++)
            D.add(arrD[i]);
        for (int i = 0; i < arrE.length; i++)
            E.add(arrE[i]);
        System.out.println(subqueries(A, B, C, D, E));
    }

    public static ArrayList<Integer> subqueries(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B,
            ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Long>> aux = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            ArrayList<Long> arr = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                arr.add(0L);
            }
            aux.add(arr);
        }

        long sumRow = 0;
        for (int i = 0; i < rows; i++) {
            long curr = A.get(i).get(0);
            sumRow += curr;
            aux.get(i).set(0, sumRow);
        }
        long sumCol = 0;
        for (int i = 0; i < cols; i++) {
            long curr = A.get(0).get(i);
            sumCol += curr;
            aux.get(0).set(i, sumCol);
        }

        for (int i = 1; i < rows; i++) {
            long sum = 0;
            for (int j = 1; j < cols; j++) {
                int curr = A.get(i).get(j);
                long left = aux.get(i).get(j - 1);
                long top = aux.get(i - 1).get(j);
                long topLeft = aux.get(i - 1).get(j - 1);

                sum = curr + left + top - topLeft;
                aux.get(i).set(j, sum);
            }
        }

        int qLen = B.size();

        long mod = 1000000007L;

        for (int i = 0; i < qLen; i++) {
            int startI = B.get(i) - 1;
            int startJ = C.get(i) - 1;
            int endI = D.get(i) - 1;
            int endJ = E.get(i) - 1;

            long sum = aux.get(endI).get(endJ);
            long mostLeft = 0;
            long mostTop = 0;
            long mostTopLeft = 0;
            if (startJ - 1 >= 0) {
                mostLeft = aux.get(endI).get(startJ - 1);
            }
            if (startI - 1 >= 0) {
                mostTop = aux.get(startI - 1).get(endJ);
            }
            if (startI - 1 >= 0 && startJ - 1 >= 0) {
                mostTopLeft = aux.get(startI - 1).get(startJ - 1);
            } 
            
            long ans = sum - (mostLeft + mostTop) + mostTopLeft;
            result.add((int)((ans + mod * mod) % mod));
        }

        return result;
    }

    public static ArrayList<Integer> subqueries1(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B,
            ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int rows = A.size();
        int cols = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < cols; j++) {
                int curr = A.get(i).get(j);
                sum += curr;
                A.get(i).set(j, sum);
            }
            System.out.println(A.get(i));
        }

        int qLen = B.size();

        for (int i = 0; i < qLen; i++) {
            int startI = B.get(i) - 1;
            int startJ = C.get(i) - 1;
            int endI = D.get(i) - 1;
            int endJ = E.get(i) - 1;

            int prefixStart = A.get(startI).get(endJ);
            int prefixEnd = A.get(endI).get(endJ);
            if (startJ - 1 >= 0) {
                prefixStart = prefixStart - A.get(startI).get(startJ - 1);
                prefixEnd = prefixEnd - A.get(endI).get(startJ - 1);
            }
            int ans = prefixStart + prefixEnd;
            result.add(ans);
        }

        return result;
    }
}
