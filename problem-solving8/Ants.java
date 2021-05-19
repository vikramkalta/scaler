import java.util.ArrayList;

public class Ants {
    public static void main(String args[]) {
        // int[] arr = { 4,3 };
        // int[] arr = { 5 };
        int[] arr = {2, 15};
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            B.add(arr[i]);

        ArrayList<Integer> C = new ArrayList<>();
        // int[] arr1 = { 0,1 };
        // int[] arr1 = { 4 };
        int[] arr1 ={5, 1};
        for (int i = 0; i < arr1.length; i++) {
            C.add(arr1[i]);
        }
        // System.out.println(ants(4, B, C));
        // System.out.println(ants(9, B, C));
        System.out.println(ants(15, B, C));
    }

    public static int ants(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int lenLeft =B.size();
        int lenRight = C.size();

        ArrayList<Integer> antsPos=new ArrayList<>();
        for (int i =0; i <= A;i++)antsPos.add(0);

        for (int i = 0; i<lenLeft; i++) {
            int curr = B.get(i);
            antsPos.set(curr, 1); // 1 for left
        }
        for (int i = 0; i < lenRight; i++) {
            int curr = C.get(i);
            antsPos.set(curr, 2); // 2 for right
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A+1; i++) {
            int curr = antsPos.get(i);
            int stepsToDie = 0;
            if (curr == 2) {
                stepsToDie = A - i;
            } else if (curr == 1) {
                stepsToDie = i - 0;
            }
            if (max < stepsToDie) {
                max = stepsToDie;
            }
        }

        return max;
    }
}
