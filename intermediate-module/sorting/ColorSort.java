package sorting;
import java.util.ArrayList;

public class ColorSort {
    public static void main(String args[]) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        ArrayList<Integer> A = new ArrayList<>();
        for(int i = 0; i < arr.length;i++) {
            A.add(i);
        }
        System.out.println(A);
    }

    public static ArrayList<Integer> colorSort(ArrayList<Integer> A) {
        int len = A.size();

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (curr == 0) {
                count0++;
            } else if (curr == 1) {
                count1++;
            } else if (curr == 2) {
                count2++;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < count0; i++) {
            result.add(0);
        }
        int count1Len = count0 + count1;
        for (int i = count0; i < count1Len; i++) {
            result.add(1);
        }
        int count2Len = count1Len + count2;
        for (int i = count1Len; i < count2Len; i++) {
            result.add(2);
        }
        return result;
    }
}
