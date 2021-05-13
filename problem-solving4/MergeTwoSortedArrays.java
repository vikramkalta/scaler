import java.util.ArrayList;

public class MergeTwoSortedArrays {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 3, 4, 5, 6 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        int[] arr1 = { 3, 3, 5 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
            B.add(arr1[i]);
        System.out.println(mergeTwoSortedArrays(A, B));
    }

    public static ArrayList<Integer> mergeTwoSortedArrays(ArrayList<Integer> A, ArrayList<Integer> B){
        int lenA = A.size();
        int lenB = B.size();
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0; int j = 0;
        while (i < lenA && j < lenB) {
            int currA = A.get(i);
            int currB = B.get(j);
            if (currA > currB) {
                result.add(currB);
                j++;
            } else {
                result.add(currA);
                i++;
            }
        }
        
        while(i < lenA) {
            int curr = A.get(i);
            result.add(curr);
            i++;
        }
        while(j < lenB) {
            int curr = B.get(j);
            result.add(curr);
            j++;
        }

        return result;
    }
}
