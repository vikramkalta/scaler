import java.util.ArrayList;
import java.util.Collections;

public class SortUnsorted {
    public static void main(String args[]) {
        int[] arr = {-355071087, -679308132, 398052175, 755454983, 814022370, 889267058};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0;i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(sortUnsorted(A));
    }

    public static int sortUnsorted(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Integer> copyA = new ArrayList<>(A);
        Collections.sort(copyA);

        int startI = -1;
        int endI = -1;
        for (int i = 0; i < len; i ++) {
            int currA = A.get(i);
            int currCopy = copyA.get(i);

            if (currA != currCopy && startI < 0) {
                startI = i;
            }
            if (startI >= 0 && currA != currCopy) {
                endI = i;
            }
        }

        if (startI == -1 && endI == -1) {
            return 0;
        }
        return endI - startI + 1;
    }
}
