import java.util.ArrayList;

public class Subsequence {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        ArrayList<Integer> temp = new ArrayList<>();
        findSubsequence(A, temp);
        System.out.println(result);
    }

    public static void findSubsequence(ArrayList<Integer> A, ArrayList<Integer> temp) {
        if (A.size() == 0) {
            result.add(temp);
            return;
        }
        int firstElement = A.get(0);
        A.remove(0);
        temp.add(firstElement);
        findSubsequence(A, temp);
        // int firstTempElement = temp.get(0);
        temp.remove(0);
        findSubsequence(temp, temp);
    }
}
