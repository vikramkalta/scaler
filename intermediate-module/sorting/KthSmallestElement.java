import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestElement {
    public static void main(String args[]) {
        // int[] arr = {2, 1, 4, 3, 2};
        int[] arr = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            A.add(arr[i]);
        }
        // System.out.println(kthSmallestElement(A, 3));
        System.out.println(kthSmallestElement(A, 9));
    }

    public static int kthSmallestElement(final List<Integer> A, int B) {
        int len = A.size();

        ArrayList<Integer> _A = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            _A.add(A.get(i));
        }

        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < B; i++) {
            min = _A.get(i);
            minIndex = i;
            for (int j = i; j < len; j++) {
                int curr = _A.get(j);
                if (min > curr) {
                    min = curr;
                    minIndex = j;
                }
            }
            int temp = _A.get(i);
            _A.set(i, min);
            _A.set(minIndex, temp);
        }
        return _A.get(B-1);
    }
}
