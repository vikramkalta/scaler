import java.util.ArrayList;

public class SumLessThan4 {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(2);A.add(3);solve(A);
    }

    public static void solve(ArrayList<Integer> A) {
        recur(A, new ArrayList<>(), 0, 0);
    }

    private static void recur(ArrayList<Integer> A, ArrayList<Integer> temp, int index, int sum) {
        if (temp.size() == 3 && sum < 4) {
            System.out.println("ans " + sum);
            return;
        }
        if (sum >= 4) {
            System.out.println("sum " + sum);
            return;
        }
        if (index == 3) {
            int rem = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            sum-=rem;
            return;
        }
        int num = A.get(index);
        sum = sum + num;
        temp.add(num);
        recur(A, temp, index, sum);
        int rem = temp.get(temp.size() - 1);
        temp.remove(temp.size() - 1);
        sum-=rem;
        recur(A, temp, index + 1, sum);
    }
}
