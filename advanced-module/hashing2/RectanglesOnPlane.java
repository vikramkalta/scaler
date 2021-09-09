import java.util.ArrayList;

public class RectanglesOnPlane {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        int[] a = { 1, 1, 2, 2 };
        int[] b = { 1, 2, 1, 2 };
        // int[] a = { 1, 1, 2, 2 };
        // int[] b = { 1, 2, 2, 1 };
        // int[] a = { 1, 1, 2, 3, 3 };
        // int[] b = { 1, 2, 1, 2, 1 };
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        for (int i = 0; i < b.length; i++)
            B.add(b[i]);
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer>B) {
        int len = A.size();
        int count = 0;
        for (int i = 0; i < len - 3; i++) {
            int currX1 = A.get(i);
            int currY1 = B.get(i);
            for (int j = i + 1; j < len - 2; j++) {
                int currX2 = A.get(j);
                int currY2 = B.get(j);
                for (int k = j + 1; k < len - 1; k++) {
                    int currX3 = A.get(k);
                    int currY3 = B.get(k);
                    for (int l = k + 1; l < len; l++) {
                        int currX4 = A.get(l);
                        int currY4 = B.get(l);

                        boolean x=false,y=false;
                        if ((currX1 == currX3 && currY2 == currY4) 
                        || (currX1 == currX2 && currY3 == currY4)
                        || (currX1 == currX4 && currY2 == currY3)
                        || (currX2 == currX3 && currY1 == currY4)
                        || (currX2 == currX4 && currY1 == currY3)
                        || (currX3 == currX4 && currY1 == currY2)) {
                            x=true;
                        }
                        if ((currY1 == currY2 && currX3 == currX4) 
                        || (currY1 == currY3 && currX2 == currX4)
                        || (currY1 == currY4 && currX2==currX3)
                        ||(currY2 == currY3 && currX1 == currX4)
                        || (currY2 == currY4 && currX1 == currX3)
                        || (currY3 == currY4 && currX1 == currX2)) {
                            y=true;
                        }
                        // if ((currX1 == currX3 && currY2 == currY4) 
                        // || (currX1 == currX2 && currY3 == currY4)
                        // || (currX1 == currX4 && currY2 == currY3)
                        // || (currX2 == currX3 && currY1 == currY4)
                        // || (currX2 == currX4 && currY1 == currY3)
                        // || (currX3 == currX4 && currY1 == currY2)) {
                        //     x=true;
                        // }
                        // if ((currY1 == currY2 && currX3 == currX4) 
                        // || (currY1 == currY3 && currX2 == currX4)
                        // || (currY1 == currY4 && currX2==currX3)
                        // ||(currY2 == currY3 && currX1 == currX4)
                        // || (currY2 == currY4 && currX1 == currX3)
                        // || (currY3 == currY4 && currX1 == currX2)) {
                        //     y=true;
                        // }
                        if (x&y) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
