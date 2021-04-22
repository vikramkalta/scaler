import java.util.ArrayList;

public class IsAlpha {
    public static void main(String args[]) {
        char[] arr = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        ArrayList<Character> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            A.add(arr[i]);
        }
        System.out.println(isAlpha(A));
    }

    public static int isAlpha(ArrayList<Character> A) {
        int len = A.size();

        boolean isAlpha = true;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (curr >= 'A' && curr <= 'z') {
                continue;
            } else {
                isAlpha = false;
                break;
            }
        }
        return isAlpha ? 1 : 0;
    }
}
