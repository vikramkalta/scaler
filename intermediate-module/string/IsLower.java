package string;
import java.util.ArrayList;

public class IsLower {
    public static void main(String args[]) {
        // char[] arr = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        char[] arr = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        ArrayList<Character> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            A.add(arr[i]);
        }
        System.out.println(isLower(A));
    }

    public static ArrayList<Character> isLower(ArrayList<Character> A) {
        int len = A.size();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr >= 'A' && curr <= 'Z') {
                curr = curr + 32;
                A.set(i, (char)curr);
            } else {
                continue;
            }
        }
        return A;
    }
}
