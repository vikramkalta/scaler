import java.util.ArrayList;

public class CircleOfMonsters {
    public static void main(String args[]) {
        // int[] arr = { 7,2,5 };
        int[] arr = {29, 16, 44, 21, 25, 23};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        ArrayList<Integer> B = new ArrayList<>();
        // int[] arr1 = { 15,14,3 };
        int[] arr1 = { 32, 36, 49, 36, 11, 32 };
        for (int i = 0; i < arr1.length; i++) {
            B.add(arr1[i]);
        }
        System.out.println(circleOfMonsters(A, B));
    }

    public static int circleOfMonsters(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        long sum = 0l;
        for (int i = 0; i < len; i++) {
            int nextIndex = i+1;
            if (i == len-1) {
                nextIndex = 0;
            }
            int nextHealth = A.get(nextIndex);
            int currDamage = B.get(i);
            int max = max(0, (nextHealth - currDamage));
            sum+=max;
        }
        long min = Long.MAX_VALUE;
        for (int i=0;i<len;i++) {
            int curr = A.get(i);
            int prevIndex = i - 1;
            if (i == 0) {
                prevIndex = len -1;
            }
            int prevDamage = B.get(prevIndex);
            long bullets = sum + curr;
            int previousDamage = max(0, (curr - prevDamage));
            bullets = bullets - previousDamage;
            if (min > bullets) {
                min = bullets;
            }
        }
        return (int)(min % 1000000007);
    }

    private static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
}
