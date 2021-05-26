import java.util.ArrayList;

public class EquilibriumIndex {
    public static void main(String args[]) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(equilibriumIndex(A));
    }

    public static int equilibriumIndex(ArrayList<Integer> A) {
        int len = A.size();

        int sumLeft = 0;
        int sumRight = 0;
        boolean isFound = false;

        int equilibriumIndex = 0;
        while(equilibriumIndex < len - 1) {
            for (int i = 0; i < equilibriumIndex; i++) {
                int curr = A.get(i);
                sumLeft += curr;
            }
            for (int i = equilibriumIndex + 1; i < len; i++) {
                int curr = A.get(i);
                sumRight += curr;
            }
            if (sumLeft == sumRight) {
                isFound = true;
                break;
            } else {
                sumLeft = 0;
                sumRight = 0;
            }
            equilibriumIndex++;
        }
        
        return isFound ? equilibriumIndex : -1;
    }

    // public static int equilibriumIndex(ArrayList<Integer> A) {
    //     int len = A.size();

    //     int sum = 0;
    //     ArrayList<Integer> prefix = new ArrayList<>();
    //     ArrayList<Integer> suffix = new ArrayList<>();

    //     int ans= 0;
    //     for (int i = 0; i < len; i++) {
    //         int curr = A.get(i);
    //         sum += curr;
    //         prefix.add(sum);
    //     }
    //     for (int i = len - 1; i>= 0; i--) {
    //         int curr = A.get(i);
    //         sum += curr;
    //         suffix.add(sum);
    //     }
    //     for (int i = 1; i < len -1; i++) {
    //         int currPre = prefix.get(i);
    //         int currSuff = suffix.get(i);
    //         if (currPre == currSuff) {
    //             ans = i;
    //             break;
    //         }
    //     }
    //     return ans;
    // }
}
