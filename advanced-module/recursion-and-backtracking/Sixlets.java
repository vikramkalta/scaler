import java.util.ArrayList;

public class Sixlets {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 8 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println();
        gen("abc", 0, "");
    }

    public static void gen(String str, int index, String temp) {
        if (temp.length() == 0) {
            System.out.println(str);
            return;
        }
        String s = str.substring(1, str.length() - 1);
        // gen(s, index + 1, s.charAt(0));
    }

    public static void solve(ArrayList<Integer> A, int B) {
        int len = A.size();
    }
}