import java.util.ArrayList;

public class LargestNumber {
    public static void main(String args[]) {
        // int[] arr = { 3, 30, 34, 5, 9 };
        // int[] arr = { 12, 121 };
        // int[] arr = { 298, 29 };
        int[] arr = { 29, 298 };
        // int[]arr={782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357,
        // 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470,
        // 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905};
        // int[] arr = { 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412 };
        // int[] arr = { 9, 99, 999, 9999, 9998 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    // 99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372929827126124019124113
    // 99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372982927126124019124113
    public static String solve(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
            a.add(curr);
        }

        int countOfDig = 1, specialDig = 1;
        while (true) {
            specialDig = specialDig * 10;
            int x = max % specialDig;
            if (x == max) {
                break;
            }
            countOfDig++;
        }

        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bucket.add(new ArrayList<>());
        }

        int x = 1;
        for (int i = 0; i < countOfDig; i++) {
            int y = x;
            x = x * 10;
            for (int j = 0; j < len; j++) {
                int currJ = a.get(j);
                int _currJ = currJ;
                String str = String.valueOf(currJ);
                int strLen = str.length();
                if (countOfDig > strLen) {
                    int lastDig = currJ % 10;
                    int diff = countOfDig - strLen;
                    for (int w = 0; w < diff; w++) {
                        str += lastDig;
                    }
                    _currJ = Integer.parseInt(str);
                }
                int buck = _currJ % x;
                buck = buck / y;
                bucket.get(buck).add(currJ);
                // }
                // int buck = currJ % x;
                // if (buck == currJ) {
                // int t = currJ % 10;
                // bucket.get(t).add(currJ);
                // } else {
                // buck = buck / y;
                // bucket.get(buck).add(currJ);
                // }
                System.out.println(bucket);
            }
            a.clear();
            for (int j = 0; j < 10; j++) {
                int buckLen = bucket.get(j).size();
                for (int k = 0; k < buckLen; k++) {
                    a.add(bucket.get(j).get(k));
                }
                // System.out.println(A);
                bucket.get(j).clear();
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            int curr = a.get(i);
            if (ans.length() == 0 && curr == 0) {
                continue;
            }
            ans.append(String.valueOf(curr));
        }
        if (ans.length() == 0)
            ans.append("0");
        return new String(ans);
    }
}
// int dividend = 10;
// int weirdCount = diff;
// while (weirdCount > 0) {
// dividend *= 10;
// weirdCount--;
// }
// t = currJ % dividend;
// t = t / (dividend / 10);