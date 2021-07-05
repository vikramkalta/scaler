import java.util.ArrayList;

public class MergeTwoSortedArrays {
    public static void main(String args[]) {
        int[] arr = { -4, 3 };
        // int[] arr = { 5, 10, 20 };
        // int[] arr = { 1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        int[] arr1 = { -2, -2 };
        // int[] arr1 = { 1, 2, 30 };
        // int[] arr1 = { 2, 4 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
            B.add(arr1[i]);
        // System.out.println(solve(A, B, 9));
        // System.out.println(solve(A, B, 13));
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len1 = A.size(), len2 = B.size();
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < len1 && j < len2) {
            int curr1 = A.get(i);
            int curr2 = B.get(j);
            if (curr1 <= curr2) {
                result.add(curr1);
                i++;
            } else {
                result.add(curr2);
                j++;
            }
            k++;
        }
        while (i < len1) {
            result.add(A.get(i));
            i++;
        }
        while (j < len2) {
            result.add(B.get(j));
            j++;
        }
        return result;
    }
}
