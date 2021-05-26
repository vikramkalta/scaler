import java.util.ArrayList;

public class ReturnDiff {
    public static void main(String args[]) {
        // int a[] = {1,2,100,89};
        int a[]={-98, 54, -52, 15, 23, -97, 12, -64, 52, 85};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(returnDiff(arr));
    }

    public static int returnDiff(ArrayList<Integer> A) {
        int len = A.size();

        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (A.get(i) % 2 == 0 && A.get(i) > maxEven) {
                maxEven = A.get(i);
            }
            System.out.println("A.get(i)%2 : " + A.get(i) + ":: " + A.get(i) % 2);
            if (A.get(i) % 2 != 0 && A.get(i) < minOdd) {
                minOdd = A.get(i);
            }
        }
        return maxEven - minOdd;
    }
}
