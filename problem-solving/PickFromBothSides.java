import java.util.ArrayList;

public class PickFromBothSides {
    public static void main(String args[]) {
        int[] a = {5, -2, 3 , 1, 2};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        System.out.println(pickFromBothSides(A, 3));
    }

    public static int pickFromBothSides(ArrayList<Integer> A, int B) {
        int len = A.size();
        
        int sum = 0;
        int max = sum;

        for (int i = 0; i < B; i++) {
            int curr = A.get(i);
            sum = sum + curr;
        }
        max = sum;

        int i = 1;
        while (i <= B) {
            int front = A.get(B - i);
            sum = sum - front;
            int back = A.get(len - i);
            sum = sum + back;
            if (sum > max) {
                max = sum;
            }
            i++;
        }

        return max;
    }
}
