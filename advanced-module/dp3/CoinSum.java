import java.util.ArrayList;

public class CoinSum {
    public static void main(String args[]) {
        // int[]arr={1,2,3};
        int[]arr={2, 5, 3, 6};
        // int B = 4;
        int B= 10;
        ArrayList<Integer> A=new ArrayList<>();
        for(int i =0 ; i <arr.length;i++)A.add(arr[i]);
        System.out.println(solve(A, B));
    }

    static int _ans = 0;
    public static int solve(ArrayList<Integer> A, int B) {
        coinSum(A, B, 0, 0);
        return _ans;
    }

    public static int coinSum(ArrayList<Integer> A, int B, int i, int sum) {
        if (i > A.size() - 1) {
            return _ans;
        }
        if (sum >= B) {
            if (sum == B) {
                _ans++;
            }
            return _ans;
        }
        int curr = A.get(i);
        sum+=curr;
        coinSum(A, B, i, sum);
        sum-=curr;
        coinSum(A, B, i + 1, sum);
        return _ans;
    }
}
