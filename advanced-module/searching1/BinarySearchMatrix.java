import java.util.ArrayList;

public class BinarySearchMatrix {
    public static void main(String args[]) {
        // int[][] arr = { { 1, 2, 3 }, { 3, 4, 5 }, { 5, 6, 7 } };
        int[][] arr1 = { { 3 }, { 29 }, { 36 }, { 63 }, { 67 }, { 72 }, { 74 }, { 78 }, { 85 } };
        int[][] arr = { { 3, 3, 11, 12, 14 }, { 16, 17, 30, 34, 35 }, { 45, 48, 49, 50, 52 }, { 56, 59, 63, 63, 65 },
                { 67, 71, 72, 73, 79 }, { 80, 84, 85, 85, 88 }, { 88, 91, 92, 93, 94 } };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                curr.add(arr[i][j]);
            }
            A.add(curr);
        }
        // System.out.println(solve(A, 4));
        // System.out.println(solve(A, 41));
        System.out.println(solve(A, 94));
    }

    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int row = A.size();
        int col = A.get(0).size();
        int lR = 0, rR = row - 1, mR = (lR + rR) / 2;
        int lC = 0, rC = col - 1, mC = (lC + rC) / 2;

        int foundRow = -1;
        int ans = 0;
        while (lR <= rR) {
            int elMidR = A.get(mR).get(0);
            int elMidRLast = A.get(mR).get(col - 1);
            if (elMidR == B || elMidRLast == B) {
                ans = 1;
                break;
            } else if (B > elMidR && B < elMidRLast) {
                foundRow = mR;
                break;
            } else if (elMidR < B) {
                lR = mR + 1;
            } else if (elMidR > B) {
                rR = mR - 1;
            }
            mR = (lR + rR) / 2;
        }
        if (foundRow > -1) {
            while (lC <= rC) {
                int elMidC = A.get(foundRow).get(mC);
                if (elMidC == B) {
                    ans = 1;
                    break;
                } else if (elMidC > B) {
                    rC = mC - 1;
                } else if (elMidC < B) {
                    lC = mC + 1;
                }
                mC = (lC + rC) / 2;
            }
        }

        return ans;
    }
}
