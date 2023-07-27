import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FirstNonRepeating2 {
    public static void main(String[] args) {
        // String A = "abadbc";
        // String A = "abcabc";
        // String A = "jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl";
        String A = "jpxvxivxkkthvpqhhhjuzhkegnzqriokhsgea";
        // sssssssssssssssssssssssssnnnnnnniiiiiiiiiiiiiiiiifffffffffffffffffffffffffffffoooooooooooooooooooooooooooooooooooooooooodddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
        // sssssssssssssssssssssssssnnnnnnniiiiiiiiiiiiiiiiifffffffffffffffffffffffffffffoooooooooooooooooooooooooooooooooooooooooodddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
        System.out.println(solve(A));
    }

    public static String solve(String A) {
        StringBuilder ans = new StringBuilder();
        LinkedList<Character> queue = new LinkedList<>();
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char curr = A.charAt(i);
            ArrayList<Character> removeList = new ArrayList<>();
            if (map.containsKey(curr)) {
                while (!queue.isEmpty() && queue.peek() != curr) {
                    removeList.add(queue.remove());
                }
                if (!queue.isEmpty() && queue.peek() == curr) {
                    queue.remove();
                }
                for (int j = removeList.size() - 1; j >= 0; j--) {
                    queue.addFirst(removeList.get(j));
                }

            } else {
                map.put(curr, true);
                queue.add(curr);
            }
            ans.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return new String(ans);
    }
}
