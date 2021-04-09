import java.util.ArrayList;

public class ClosestMinMax {
    public static void main(String args[]) {
        // int a[]={1,2,3,4,5,6,11,7,9};
        int a[]={4, 4, 4, 4, 4};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(closestMinMax(arr));
    }

    public static int closestMinMax(ArrayList<Integer> A) {
        int len= A.size();

        int min = A.get(0);
        int max= A.get(0);
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            if (curr < min) {
                min = curr;
            }
            if (curr > max) {
                max = curr;
            }
        }
        
        int minIndex = -1;
        int maxIndex = -1;
        ArrayList<Integer> minMaxDiff = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (curr == max) {
                maxIndex = i;
                if (minIndex != -1) {
                    int diff = 0;
                    if (maxIndex > minIndex) {
                        diff = maxIndex - minIndex;
                    } else {
                        diff = minIndex - maxIndex;
                    }
                    minMaxDiff.add(diff);
                }
            }
            if (curr == min) {
                minIndex = i;
                if (maxIndex != -1) {
                    int diff = 0;
                    if (maxIndex > minIndex) {
                        diff = maxIndex - minIndex;
                    } else {
                        diff = minIndex - maxIndex;
                    }
                    minMaxDiff.add(diff);
                }
            }
        }

        int closestMinMax = minMaxDiff.get(0);
        int minMaxDiffLen = minMaxDiff.size();
        for (int i = 1; i < minMaxDiffLen; i++) {
            if (closestMinMax > minMaxDiff.get(i)) {
                closestMinMax = minMaxDiff.get(i);
            }
        }

        return closestMinMax + 1;
    }
}
