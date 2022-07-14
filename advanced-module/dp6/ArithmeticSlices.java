import java.util.ArrayList;
import java.util.HashMap;

public class ArithmeticSlices {
    public static void main(String args[]) {
        // int[] nums = {2,4,6,8,10};
        // int[] nums = {7,7,7,7,7};
        int[] nums = {0,2000000000,-294967296};
        System.out.println(numberOfArithmeticSlices(nums));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        ArrayList<HashMap<Integer, Integer>> apLists = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            apLists.add(new HashMap<>());
        }
        int ans = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int currI = nums[i];
                int currJ = nums[j];
                long diff = (currI * 1l) - (currJ * 1l);
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }
                int x = apLists.get(i).getOrDefault((int)diff, 0);
                int y = apLists.get(j).getOrDefault((int)diff, 0);
                apLists.get(i).put((int)diff, x + y + 1);
                ans += y;
            }
        }
        return ans;
    }
}