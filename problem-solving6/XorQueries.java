import java.util.ArrayList;

public class XorQueries {
    public static void main(String args[]) {
        // int[] arr = { 0, 1, 0, 1 };
        int[] arr = { 1, 1, 1, 1 };

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        int[][] arr1 = { { 2, 4 }, { 1, 5 }, { 3, 5 } };
        for (int i = 0; i < arr1.length; i++) {
            int[] currArr = arr1[i];
            ArrayList<Integer> b = new ArrayList<>();
            for (int j = 0; j < currArr.length; j++) {
                b.add(currArr[j]);
            }
            B.add(b);
        }
        System.out.println(xorQueries(A, B));
    }

    public static ArrayList<ArrayList<Integer>> xorQueries(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int lenQ = B.size();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < lenQ; i++) {
            int startI = B.get(i).get(0) - 1;
            int endI = B.get(i).get(1) - 1;
            int sum = 0;
            for (int j = startI; j <= endI; j++) {
                int curr = A.get(j);
                sum += curr;
            }
            ArrayList<Integer> ans = new ArrayList<>();
            int len = endI - startI + 1;
            int zeroes = len - sum;
            if (sum%2 != 0) {
                ans.add(1);
            } else {
                ans.add(0);
            }
            ans.add(zeroes);
            result.add(ans);
        }
        return result;
    }
}
