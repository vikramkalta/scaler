package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleElement {
    public static void main(String args[]) {

    }

    public static int nobleElement(ArrayList<Integer> A) {
        int len = A.size();

        boolean isFound = false;

        Collections.sort(A);
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int next = -1;
            if (i != len - 1) {
                next = A.get(i+1);
            }
            
            if (curr == next) {
                continue;
            }

            int diff = (len - 1) - i;

            if (diff == curr) {
                isFound = true;
                break;
            }
        }

        return isFound ? 1 : -1;
    }
}
