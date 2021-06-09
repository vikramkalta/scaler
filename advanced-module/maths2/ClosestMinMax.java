import java.util.ArrayList;

public class ClosestMinMax {
    public static void main(String args[]) {
        // int[] arr = {1,3};
        // int[] arr = {1,2,3,4,2,1,4,5};
        int[] arr = { 814, 761, 697, 483, 981 };
        // int[] arr = {1, 1, 1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
            if (min > curr) {
                min = curr;
            }
        }
        int closest= Integer.MAX_VALUE;
        for (int i = 0; i < len; i ++) {
            int curr = A.get(i);
            if (curr == max) {
                maxIndex = i;
            }
            if (curr == min) {
                minIndex = i;
            }
            if(minIndex != -1 && maxIndex != -1) {
                int diff= Math.abs(maxIndex-minIndex);
                if (closest > diff) {
                    closest = diff;
                }
            }
        }

        return closest+1;
    }
}
