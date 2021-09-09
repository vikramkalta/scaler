import java.util.ArrayList;
import java.util.HashMap;

public class TotalRightAngleTriangles {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        // int[] a = { 1, 1, 2 };
        // int[] b = { 1, 2, 1 };
        int[] a = { 1, 1, 2, 3, 3 };
        int[] b = { 1, 2, 1, 2, 1 };
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        for (int i = 0; i < b.length; i++)
            B.add(b[i]);
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        long count = 0l;
        long mod = 1000000007l;

        HashMap<Integer,Integer> x = new HashMap<>();
        HashMap<Integer,Integer> y = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int currX = A.get(i);
            int currY = B.get(i);
            if (x.containsKey(currX)) {
                int value = x.get(currX);
                value++;
                x.put(currX, value);
            }else{
                x.put(currX, 1);
            }
            if (y.containsKey(currY)) {
                int value = y.get(currY);
                value++;
                y.put(currY, value);
            }else{
                y.put(currY, 1);
            }
        }

        for (int i = 0; i < len; i++) {
            int currX1 = A.get(i);
            int currY1 = B.get(i);
            int xCount = x.get(currX1);
            int yCount = y.get(currY1);
            if (xCount>=1&&yCount>=1){
                count+= ((xCount-1) * (yCount-1));
            }
        }
        count = count % mod;
        if (count < 0)count+=mod;
        return (int)count;
    }

    public static int solve1(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        long count = 0l;
        long mod = 1000000007l;
        for (int i = 0; i < len - 2; i++) {
            int currX1 = A.get(i);
            int currY1 = B.get(i);
            for (int j = i + 1; j < len - 1; j++) {
                int currX2 = A.get(j);
                int currY2 = B.get(j);
                for (int k = j + 1; k < len; k++) {
                    int currX3 = A.get(k);
                    int currY3 = B.get(k);
                    boolean x = false, y = false;
                    if ((currX1 == currX2) || (currX2 == currX3) || (currX1==currX3)) {
                        x= true;
                    }
                    if ((currY1 == currY2) || (currY2 == currY3) || (currY1==currY3)) {
                        y=true;
                    }
                    if (x && y){
                        count++;
                    }
                }
            }
        }
        count = count % mod;
        if (count < 0)count+=mod;
        return (int)count;
    }
}
