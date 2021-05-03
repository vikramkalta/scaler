import java.util.ArrayList;

public class Rearrange {
    public static void main(String args[]) {
        int[] arr = {4, 0, 2, 1, 3};
        // 3,0,2,1,4
        // 3,4,2,1,0
        // 3,4,2,1,0
        // 3,4,2,0,1
        // 3,4,2,0,1
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(rearrange(A));
    }

    public static ArrayList<Integer> rearrange(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Integer> B = new ArrayList<>(A);

        for (int i = 0; i < len; i++) {
            int curr = B.get(i);
            int arrangedEl = B.get(curr);

            A.set(i, arrangedEl);
        }
        return A;
    }
}
