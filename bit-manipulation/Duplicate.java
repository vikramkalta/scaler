public class Duplicate {
    public static void main(String args[]) {
        int a[] = {1,2,2,3,3,1,4};
        int ans = GetDuplicate(a);
        System.out.println("ans :" + ans);
    }

    public static int GetDuplicate(int a[]) {
        int len = a.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans ^= a[i];
            System.out.println("ans :" + ans);
        }
        return ans;
    }
}
// 0 1 1
// 0 1 0
// 0 0 1
// 0 1 1
// 0 1 0
