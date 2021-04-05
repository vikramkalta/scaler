import java.util.ArrayList;
import java.util.Collections;

public class MultiRotateArray {
    public static void main(String args[]) {
        int a[] = {1, 2, 3, 4, 5};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        int b[] = {2,3};
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            B.add(b[i]);
        }
        System.out.println(multiRotateArray(arr, B));
    }

    public static ArrayList<ArrayList<Integer>> multiRotateArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        int aLen = A.size();
        int bLen = B.size();

        ArrayList<Integer> newA = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < aLen; i++) {
            newA.add(A.get(i));
        }
        
        for (int i= aLen-1; i>= 0; i--) {
            newA.set(aLen - 1 - i, A.get(i));
        }

        Collections.copy(A, newA);

        for (int i = 0; i < bLen; i++) {
            int rotationCount = B.get(i) % aLen;

            int leftRotateCount = aLen - rotationCount;
            int pos = leftRotateCount;
            for (int j = aLen - 1; j >= leftRotateCount; j--) {
                newA.set(pos, A.get(j));
                pos++;
            }

            pos = 0;
            for (int j = leftRotateCount - 1; j>=0;j--) {
                newA.set(pos, A.get(j));
                pos++;
            }

            ArrayList<Integer> copyInnerArr = (ArrayList<Integer>) newA.clone();
            result.add(copyInnerArr);
        }
        return result;
    }
}
