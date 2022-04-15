import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {
    public static void main(String args[]) {
        // int[] a = {-4, 2, 3};
        // int[] b = {0, -2, 4};
        int[] a = {-49, 58, 72, -78, 9, 65, -42, -3};
        int[] b = {30, -13, -70, 58, -34, 79, -36, 27};
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
            B.add(b[i]);
        }
        System.out.println(mice(A, B));
    }

    public static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        Collections.sort(A);
        Collections.sort(B);
        int maxSteps = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int currA = A.get(i);
            int currB = B.get(i);
            int diff = Math.abs(currA - currB);
            if (maxSteps < diff) {
                maxSteps = diff;
            }
        }
        return maxSteps;
    }

    public static int mice1(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int currA = A.get(i);
            int currB = B.get(i);
            if (maxA < currA) {
                maxA = currA;
            }
            if (minA > currA) {
                minA = currA;
            }
            if (maxB < currB) {
                maxB = currB;
            }
            if (minB > currB) {
                minB = currB;
            }
        }

        int maxDiff = Math.abs(maxA - maxB);
        int minDiff = Math.abs(minA - minB);
        int x = Math.abs(maxA - minA);
        int y = Math.abs(maxB - minA);
        return Math.max(Math.max(maxDiff, minDiff), Math.max(x, y));
    }
}
