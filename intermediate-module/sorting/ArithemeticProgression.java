package sorting;
import java.util.ArrayList;
import java.util.HashMap;

public class ArithemeticProgression {
    public static void main(String args[]){
        // int[] arr = {3, 5, 1};
        int[] arr={-251, -305, -323, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(ap(A));
    }
    public static int ap(ArrayList<Integer> A) {
        int len = A.size();

        HashMap<Integer, Integer> hm = new HashMap<>();

        int min = A.get(0);
        int minIndex = 0;
        int min1 = A.get(1);

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (min > curr) {
                min = curr;
                minIndex = i;
            }

            boolean contains = hm.containsKey(curr);
            if (contains) {
                int hashVal = hm.get(curr);
                hashVal++;
                hm.replace(curr, hashVal);
            } else {
                hm.put(curr, 1);
            }
        }
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (i != minIndex) {
                if (min1 > curr) {
                    min1 = curr;
                }
            }
        }

        int diff = min1 - min;

        boolean isAP = true;

        for (int i = 1; i < len; i++) {
            int curr = min + (i * diff);

            boolean contains = hm.containsKey(curr);
            if (!contains) {
                isAP = false;
                break;
            }
        }

        return isAP ? 1 : 0;
    }
}
