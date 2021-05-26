import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PerfectCards {
    public static void main(String args[]) {
        int[] arr = { 1, 1, 2, 2, 3 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(perfectCard(A));
    }

    public static String perfectCard(ArrayList<Integer> A) {
        int len = A.size();

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            boolean contains = hm.containsKey(curr);
            if (contains) {
                int hashVal = hm.get(curr);
                hashVal++;
                hm.replace(curr, hashVal);
            } else {
                hm.put(curr, 1);
            }
        }

        HashMap<Integer, Integer> players = new HashMap<>();
        players.put(0, 0); // Player A
        players.put(1, 0); // Player B

        int i = 0;
        for (Map.Entry m : hm.entrySet()) {
            int val = (int)m.getValue();

            int key = i % 2 == 0 ? 0 : 1;
            int hashVal = players.get(key);
            hashVal = hashVal + val;
            players.replace(key, hashVal);
            i++;
        }

        int player1Val = players.get(0);
        int player2Val = players.get(1);

        String result = new String();
        if (player1Val == player2Val) {
            result = "WIN";
        } else {
            result="LOSE";
        }
        return result;
    }
}
