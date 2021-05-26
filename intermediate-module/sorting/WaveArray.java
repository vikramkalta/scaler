import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public static void main(String args[]) {
        // int[] arr = {1,2,3,4};
        int[] arr = {5,1,2,3,4};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(waveArray(A));
    }

    public static ArrayList<Integer> waveArray(ArrayList<Integer> A) {
        int len = A.size();

        Collections.sort(A);

        for (int i = 0; i < len; i = i + 2) {
            int curr = A.get(i);
            if (i+1 < len) {
                int temp = A.get(i+1);
                A.set(i, temp);
                A.set(i+1, curr);
            }
            
        }
        return A;
    }
}
