import java.util.ArrayList;

public class IsAlphaNum {
    public static void main(String args[]) {
        // char[] arr = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y'};
        char[] arr = {'S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'};
        ArrayList<Character> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            A.add(arr[i]);
        }
        System.out.println(isAlphaNum(A));
    }

    public static int isAlphaNum(ArrayList<Character> A) {
        int len = A.size();

        boolean isAlpha = true;

        for (int i = 0; i < len; i++) {
            char curr = A.get(i);
            int _curr = Character.getNumericValue(curr);

            if ((curr >= 'A' && curr <= 'z') || (_curr >= 0 && _curr <= 9)) {
                continue;
            } else {
                isAlpha = false;
                break;
            }
        }
        return isAlpha ? 1 : 0;
    }
}
