import java.util.ArrayList;

public class TimeToLevelElements {
    public static void main(String args[]) {

    }

    public static int getTime(ArrayList<Integer> A) {
        int len = A.size();
        int max = A.get(0);
        for (int i = 1; i < len; i++) {
            if (max < A.get(i)) {
                max = A.get(i);
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += (max - A.get(i));
        }
        return sum;
    }
}
