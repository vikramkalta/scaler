import java.util.ArrayList;
import java.util.Collections;

public class RemoveElements {
    public static void main(String args[]) {
        // int[] arr = {5,1,2,3,4};
        int[] arr = {2, 1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(removeElements(A));
    }

    public static int removeElements(ArrayList<Integer> A) {
        int len = A.size();

        Collections.sort(A);

        int sum=0;

        int len1 = len - 1;
        int dec = 0;
        for (int i = len1; i >= 0; i--) {
            for (int j = len1 - dec; j >= 0; j--) {
                int curr = A.get(j);
                sum = sum + curr;
            }
            dec++;
            A.remove(i);
        }

        return sum;
    }
}
