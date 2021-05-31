import java.util.ArrayList;

public class AddOneToNumber {
    public static void main(String args[]) {
        // int[]arr={1,2,3};
        // int[] arr={0,9,9,9};
        // int[] arr = {2, 5, 6, 8, 6, 1, 2, 4, 5};
        // int[] arr = {9, 9, 9, 9, 9};
        // int[] arr = { 0, 8, 9 };
        // int[] arr = {0};
        // int[] arr = {0, 0, 4, 4, 6, 0, 9, 6, 5, };
        // int[] arr = {0};
        int[] arr ={9};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(addOne(A));
    }

    public static ArrayList<Integer> addOne(ArrayList<Integer> A) {
        int lenOld = A.size();

        ArrayList<Integer> newA = new ArrayList<>();
        boolean zero = A.get(0) == 0 ? true : false;

        for (int i = 0; i < lenOld; i++) {
            int curr = A.get(i);
            if (curr != 0) {
                zero = false;
            }
            if (!zero) {
                newA.add(curr);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        boolean isPrev9 = false;
        int len = newA.size();
        if (len == 0) {
            result.add(1);
            return result;
        }
        for (int i = len - 1; i >= 0; i--) {
            int curr = newA.get(i);
            if (curr == 9 && i == len - 1) {
                result.add(0);
                if (len == 1)result.add(1);
                isPrev9 = true;
            } else if (isPrev9 && curr == 9) {
                result.add(0);
                if (i == 0) {
                    result.add(1);
                }
            } else if (isPrev9) {
                curr++;
                result.add(curr);
                isPrev9 = false;
            } else if (i == len - 1) {
                curr++;
                result.add(curr);
            } else {
                result.add(curr);
            }
        }
        int resultLen = result.size();
        int mid = resultLen / 2;
        for (int i = 0; i < mid; i++) {
            int curr = result.get(i);
            int revIndex = resultLen - 1 - i;
            int rev = result.get(revIndex);
            result.set(i, rev);
            result.set(revIndex, curr);
        }
        return result;
    }
}
