package arrays;
import java.util.ArrayList;

public class SatisfyPair {
    public static void main(String args[]) {

    }

    public static int main(ArrayList<Integer> A, int B) {
        int len = A.size();
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i+1 != j+1 && A.get(i) + A.get(j) == B) {
                    result = 1;
                    break;
                }
            }
            if (result == 1) {
                break;
            }
        }
        return result;
    }
}
