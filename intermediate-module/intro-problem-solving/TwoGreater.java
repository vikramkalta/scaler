
// package intro;
import java.util.ArrayList;
// import java.util.HashMap;

public class TwoGreater {
    public static void main(String args[]) {
        // int a[] = {1,2,3,3,40,56,4,5,6,7,23,70,5,9,99,91,93};
        // int a[] = {1,2,3,3,5,6};
        int a[] = { 5, 4, 3, 3, 2, 1 };
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            aList.add(a[i]);
        }
        twoGreater(aList);
    }

    public static ArrayList<Integer> twoGreater(ArrayList<Integer> A) {
        int max = A.get(0);
        int len = A.size();
        for (int i = 0; i < len; i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (A.get(i) > secondMax && A.get(i) < max) {
                secondMax = A.get(i);
            }
        }
        ArrayList<Integer> newA = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (A.get(i) < secondMax) {
                newA.add(A.get(i));
            }
        }
        return newA;
    }
}

// 1,2,4,2,5,6,7,1
// max-7