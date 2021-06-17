import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 5, 17, 100, 11 };
        // int[] arr = { 818, 63, 386, 563, 876, 855, 731, 933, 97, 935, 710, 27, 383,
        // 975, 582, 188, 843, 569, 742, 834,
        // 859, 938, 894, 554, 31, 506, 679, 153, 191, 816, 716, 698, 352, 688, 586,
        // 206, 228, 418, 543, 996, 918,
        // 55, 666, 133, 468, 494, 667, 596, 251, 189, 853, 15, 571, 794, 560, 835, 439,
        // 923, 933, 789, 203, 527,
        // 106, 401, 623, 97, 661, 53, 1, 17, 773, 835, 191, 887, 568, 987, 667, 620,
        // 52, 253, 334, 373, 427, 891,
        // 455, 186, 742, 375, 855, 288, 574, 67, 590, 628, 926, 260, 376, 110, 548, 40,
        // 365, 398, 704, 328, 340,
        // 927, 755, 356 };
        // int[] arr1 = { 69, 50, 9, 94, 94, 100, 11, 30, 57, 83, 71, 40, 75, 53, 12,
        // 62, 15, 38, 30, 78, 10, 42, 74, 31,
        // 42, 13, 20, 66, 74, 15, 67, 23, 50, 71, 3, 86, 9, 52, 56, 92, 60, 55, 30, 87,
        // 2 };
        int[] arr = { 169, 291, 899, 864, 809, 102, 755, 715, 216, 933, 625, 33, 648, 305, 38, 160, 290, 684, 343, 607,
                26, 303, 985, 328, 36, 940, 690, 635, 125, 797, 791, 52, 867, 487, 795, 89, 472, 952, 346, 32, 822, 796,
                934, 378, 219, 138, 65, 462, 258, 588, 100, 158, 643, 351, 674, 269, 950, 795, 389, 385, 57, 42, 490,
                515, 441, 255, 355, 775, 613, 349, 936, 776, 713, 784, 709, 106, 683, 961, 344, 528, 521, 466, 25, 20,
                788, 116, 289, 859, 971, 281, 340, 274, 278, 458, 986, 46, 163, 445, 790, 602, 213, 749, 514, 805, 996,
                52, 681, 614, 174, 668, 898, 262, 455, 907, 638, 408, 929, 202, 299, 944, 974, 646, 727, 832, 184, 334,
                849, 341, 692, 508, 692, 552, 880, 59, 893, 849, 698, 386, 706, 372, 714, 929, 661, 127, 589, 1000, 275,
                463, 877, 635, 628, 188, 926, 320, 199, 442, 189, 362, 101, 758, 419, 600, 716, 472, 102, 902, 789, 718,
                924, 625, 252, 803, 276, 761, 375, 666, 579, 58, 390, 438, 674, 758, 367, 917, 674, 969, 977, 842, 408,
                842, 742, 472, 72, 938, 502, 880, 757, 123, 156, 772, 270, 330, 138, 398, 106, 357, 736, 283, 433, 604,
                103, 132, 722, 363, 728, 204, 980, 778, 225, 869, 607, 127, 512, 874, 560, 410, 853, 25, 862, 556, 766,
                638, 487, 703, 522, 88, 288, 156, 789, 271, 986, 603, 8, 575 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 2));
        // System.out.println(solve(A, 28));
        // System.out.println(solve(A, 21));
        // System.out.println(solve(A, 96));
        System.out.println(solve(A, 16));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int len = A.size();
        long count = 0l;
        long mod = 1000000007;
        ArrayList<Integer> modArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int _mod = curr % B;
            modArr.add(_mod);
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int curr = modArr.get(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                hm.put(curr, 1);
            }
        }

        for (int i = 0; i < len; i++) {
            int curr = modArr.get(i);
            int remainder = 0;
            if (curr != 0) {
                remainder = B - curr;
            }
            if (hm.isEmpty()) {
                break;
            }
            if (!hm.containsKey(remainder)) {
                continue;
            }
            long currCount = hm.get(curr);
            if (remainder == curr) {
                if (currCount > 1) {
                    long x = ncr(currCount);
                    count = (count + x) % mod;
                    if (count < 0)
                        count += mod;
                    // count += x;
                    hm.remove(curr);
                } else {
                    continue;
                }
            } else {
                long countA = currCount;
                long countB = hm.get(remainder);
                long x = ((countA % mod) * (countB % mod)) % mod;
                if (x < 0)
                    x += mod;
                count = (count + x) % mod;
                if (count < 0)
                    count += mod;
                hm.remove(curr);
                hm.remove(remainder);
            }
        }
        count = count % mod;
        if (count < 0)
            count += mod;
        return (int) count;
    }

    private static long ncr(long n) {
        long mod = 1000000007;
        long ans = n * (n - 1) / 2;
        return ans % mod;
    }

    public static int solve1(ArrayList<Integer> A, int B) {
        int len = A.size();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            for (int j = i + 1; j < len; j++) {
                int currJ = A.get(j);
                if ((currI + currJ) % B == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
