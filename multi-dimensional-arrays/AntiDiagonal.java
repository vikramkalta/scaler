import java.util.ArrayList;

public class AntiDiagonal {
    public static void main(String args[]) {
        // int arr[][] = {
        // {0}
        // };
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, };
        // int arr[][] = {
        // {1,2,3,4},
        // {5,6,7,8},
        // {9,10,11,12},
        // {13,14,15,16}
        // };
        // int arr[][] = {
        // {1,2,3,4,5},
        // {6,7,8,9,10},
        // {11,12,13,14,15},
        // {16,17,18,19,20},
        // {21,22,23,24,25}
        // };
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> iA = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                iA.add(arr[i][j]);
            }
            A.add(iA);
        }
        System.out.println(antiDiagonal(A));
    }

    public static ArrayList<ArrayList<Integer>> antiDiagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int B = 0;
        int len = A.size();
        int adjustedLen = len + len - 1;

        for (int i = 0; i < adjustedLen; i++) {
            ArrayList<Integer> dummyArr = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                dummyArr.add(0);
            }
            result.add(dummyArr);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int curr = A.get(i).get(j);
                result.get(B + j).set(i, curr);
            }
            B++;
        }
        // System.out.println("x : " + result);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                if (j > i) {
                    result.get(i).remove(j);
                    j--;
                }
            }
        }
        for (int i = len; i < adjustedLen; i++) {
            int arrLen = result.get(i).size();
            for (int j = arrLen - 1; j >= 0; j--) {
                if (j <= i - arrLen) {
                    result.get(i).remove(j);
                }
            }
        }

        return result;
    }
}
