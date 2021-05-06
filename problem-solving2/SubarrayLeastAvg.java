import java.util.ArrayList;

public class SubarrayLeastAvg {
    public static void main(String args[]) {
        // int[] arr = {3, 7, 90, 20, 10, 50, 40};
        // int[] arr = {3, 7, 5, 20, -10, 0, 12};
        int[] arr = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(subarrayLeastAvg(A, 1));
        // System.out.println(subarrayLeastAvg(A, 2));
        System.out.println(subarrayLeastAvg(A, 9));
    }

    public static int subarrayLeastAvg(ArrayList<Integer> A, int B) {
        int len = A.size();

        double minAvg = Integer.MAX_VALUE;
        int minAvgIndex = 0;
        double avg = 0;
        double sum = 0;
        for (int i = 0; i < len; i++) {
            double curr = A.get(i);

            if (i < B) {
                sum = sum + curr;
            }

            if (i == B - 1) {
                avg = sum / B;
                if (minAvg > avg) {
                    minAvg = avg;
                    minAvgIndex = i - B + 1;
                }
            }
            if (i > B) {
                int startEl = A.get(i - B);
                sum = sum - startEl;
                sum = sum + curr;
                avg = sum / B;
                if (minAvg > avg) {
                    minAvg = avg;
                    minAvgIndex = i - B + 1;
                }
            }
        }

        return minAvgIndex;
    }
}