import java.util.ArrayList;

public class MaximumJobs {
    public static void main(String args[]) {
        // int[] a = {1, 5, 7, 1};
        // int[] b = {7, 8, 8, 8};
        // int[] a = {3, 2, 6};
        // int[] b = {9, 8, 9};
        // int[] a = { 3, 13, 7, 7, 10, 3 };
        // int[] b = { 6, 15, 9, 8, 16, 11 };
        int[] a = { 12, 4202, 8, 3659, 11, 4, 14, 11, 6334, 6, 3, 11, 6, 11, 13, 13, 3196, 11, 4273, 13, 17, 19, 13, 12,
                14, 11, 13, 16, 4624, 7, 13, 2374, 3679, 12, 14, 8, 13, 10, 2418, 14, 9, 17, 13, 19, 11, 4875, 5, 11,
                13, 17, 13, 16, 18, 14, 2992, 8, 11, 20, 13, 17, 11, 3946, 6929, 12, 3033, 3344, 18, 16, 6300, 3018, 6,
                8, 18, 8, 5346, 14, 4, 20, 15, 4, 13, 12, 12, 9, 10, 17, 13, 8, 10, 4711, 9, 7, 8, 7389, 7377, 16, 10,
                8, 17, 7, 5, 18, 7178, 11, 3094, 12, 3578, 14, 11, 14, 18, 10, 3, 13, 12, 9, 8, 4714, 13, 2172, 16, 10,
                13, 1177, 15, 10, 2664, 11, 9, 3122, 11, 6435, 13, 5287, 16, 4747, 2348, 8, 3530, 3029, 14, 3974, 8, 13,
                7, 16, 3454, 20, 12, 4659, 14, 13, 2607, 1973, 10, 13, 8, 7, 5570, 2003, 8, 7, 8, 9, 10, 6, 9, 11, 7, 6,
                4288, 12, 3905, 7, 1574, 17, 7, 12, 3358, 13, 10, 12, 13, 4158, 12, 2682, 2878, 14, 10, 12, 7, 11, 13,
                16, 4531, 8, 1671, 5059, 17, 5, 15, 20, 17, 6, 16, 9, 4, 2936, 9, 11, 20, 4, 9, 10, 20, 3554, 4, 17, 7,
                14, 15, 12, 4, 4502, 3, 18, 8, 9, 2432, 2889, 12, 10, 9, 10, 4512, 18, 3340, 5725, 3973, 8, 5790, 16, 8,
                8, 8, 10, 12, 17, 2152, 10, 20, 18, 4663, 14, 16, 8, 5742, 19, 10, 9, 15, 4159, 14, 9, 15, 10, 5, 4, 7,
                13, 2928, 13, 21, 17, 8, 9, 21, 2129, 6, 13, 2527, 17, 6, 5408, 1658, 6, 12, 11, 13, 12, 10, 4, 12,
                5629, 9, 3865, 2463, 3, 15, 1414, 12, 21, 8, 3154, 13, 15, 936, 21, 7, 17, 7, 11, 5267, 15, 14, 4, 13,
                21, 8, 19, 5, 17, 6, 6, 5, 4, 3235, 8, 8, 11, 18, 10, 15, 5371, 16, 2185, 10, 10, 13, 16, 2, 15, 14, 15,
                10, 4055, 7899, 1313, 15, 15, 9, 8, 6442, 3248, 16, 13, 10, 11, 13, 2639, 8, 14, 15, 5, 15, 11, 12, 19,
                12, 19, 13, 10, 11, 17, 5456, 15, 9, 4143, 17, 4, 18, 18, 7, 4, 9, 18, 11, 11, 10, 22, 2814, 10, 10,
                3070, 5501, 4, 5921, 10, 13, 10, 13, 4276, 6075, 9, 15, 7818, 1132, 7, 10, 7, 7, 5, 12, 3313, 5, 13, 15,
                5553, 11, 7, 7, 8, 11, 10, 13, 3403, 4923, 6, 4402, 6233, 5, 4233, 5781, 5771, 6, 15, 9, 6 };
        int[] b = { 3650, 6969, 2960, 8289, 12, 3250, 17, 5644, 10136, 8165, 18, 16, 16, 5473, 17, 6739, 6191, 2541,
                5179, 7047, 4063, 7238, 14, 5325, 4090, 19, 18, 6744, 7075, 5872, 16, 5965, 7292, 3215, 6460, 9, 15,
                6131, 3743, 5813, 9419, 4658, 6783, 9143, 15, 8535, 4670, 21, 16, 8079, 6522, 18, 8834, 19, 8942, 5905,
                14, 22, 5169, 5193, 18, 8372, 9590, 6476, 4490, 7759, 2710, 3523, 7940, 7974, 16, 3492, 6183, 15, 8345,
                2520, 14, 2528, 4108, 5, 14, 6770, 13, 14, 3666, 6018, 6654, 4788, 13, 5470, 8740, 3747, 17, 7501, 7902,
                8331, 8041, 901, 18, 7795, 6757, 5889, 9878, 12, 4348, 3802, 3927, 9145, 13, 15, 3779, 7802, 18, 4943,
                3619, 7559, 14, 6562, 5096, 9968, 5580, 8021, 14, 3501, 5442, 3426, 6615, 7573, 12, 3761, 6841, 9238,
                1493, 7428, 7866, 6753, 6629, 8289, 5799, 5839, 7256, 5283, 12, 5281, 15, 4645, 8515, 21, 14, 7327,
                4251, 3327, 4175, 2437, 6183, 16, 4863, 3883, 8414, 9345, 4914, 5587, 10, 19, 4738, 7512, 7590, 7097,
                3073, 7285, 7991, 8646, 5833, 8246, 3566, 4527, 5837, 7199, 7323, 4681, 5025, 7612, 4709, 6626, 13,
                3397, 7224, 4560, 6354, 4164, 19, 4608, 5843, 7014, 6318, 10, 2019, 5202, 6400, 18, 7534, 6423, 3943,
                1793, 4913, 3511, 3401, 5963, 15, 8426, 3687, 8043, 6542, 17, 6248, 4492, 6564, 19, 4609, 2298, 5799,
                14, 1670, 5221, 17, 2582, 7563, 7593, 8015, 7416, 5069, 13, 9651, 6964, 7345, 9508, 7104, 9752, 5987,
                14, 5846, 5444, 9, 16, 217, 3909, 5406, 18, 4556, 13, 6998, 3900, 4915, 5937, 4617, 20, 8114, 6600,
                3126, 6555, 16, 8132, 6171, 1896, 17, 6753, 7572, 2285, 11, 5052, 6302, 818, 3090, 3888, 3523, 10, 9060,
                6919, 1514, 3429, 7110, 4811, 7, 5476, 3190, 15, 2496, 3056, 8262, 8526, 3862, 7, 8142, 5718, 9382,
                5026, 5144, 9, 6025, 7555, 4100, 6798, 16, 4827, 2720, 4493, 5489, 7486, 17, 7472, 5309, 18, 8834, 19,
                3540, 12, 7779, 8369, 15, 5696, 13, 2878, 10, 16, 3649, 4232, 9512, 8198, 6967, 5966, 6712, 1313, 17,
                7003, 1510, 6281, 4668, 5327, 14, 5801, 11, 16, 16, 6890, 6146, 5302, 7946, 5846, 1323, 19, 1566, 5419,
                9338, 3369, 4035, 706, 6852, 8021, 18, 6950, 3619, 4988, 8509, 2878, 6996, 4632, 6027, 6523, 2936, 7148,
                4568, 15, 9214, 3494, 5475, 9451, 8437, 7773, 4843, 7690, 20, 2395, 10007, 11, 5575, 5331, 17, 6521, 11,
                8624, 7593, 5084, 17, 9886, 7011, 3298, 8693, 15, 14, 13, 3791, 4650, 7204, 19, 5275, 8304, 3821, 2750,
                16, 3057, 7126, 10, 13, 4174, 13, 598, 19, 5651, 12, 11, 16, 5140, 16, 15, 4636, 4107, 5066, 1255, 8575,
                6708, 3790, 5388, 7384, 6034, 7567, 2662, 17, 13 };
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
            B.add(b[i]);
        }
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();
        int maxJobs = Integer.MIN_VALUE;
        merge(A, B, 0, len - 1);
        // for (int i = 0; i < len; i++) {
        // int jobs = 1;
        // // int startTimeI = A.get(i);
        // int endTimeI = B.get(i);
        // for (int j = i + 1; j < len; j++) {
        // int startTimeJ = A.get(j);
        // if (endTimeI <= startTimeJ) {
        // endTimeI = B.get(j);
        // jobs++;
        // }
        // }
        // // System.out.println("Jobs " + jobs);
        // if (jobs > maxJobs) {
        // maxJobs = jobs;
        // }
        // }
        int endTime = B.get(0);
        int jobs = 1;
        for (int i = 1; i < len; i++) {
            int startTime = A.get(i);
            if (endTime <= startTime) {
                jobs++;
                endTime = B.get(i);
            }
        }
        return jobs;
    }

    public static void merge(ArrayList<Integer> A, ArrayList<Integer> B, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        merge(A, B, l, m);
        merge(A, B, m + 1, r);
        mergeSort(A, B, l, m, r);
    }

    public static void mergeSort(ArrayList<Integer> A, ArrayList<Integer> B, int l, int m, int r) {
        ArrayList<Integer> startTimeListLeft = new ArrayList<>();
        ArrayList<Integer> startTimeListRight = new ArrayList<>();
        ArrayList<Integer> endTimeListLeft = new ArrayList<>(); 
        ArrayList<Integer> endTimeListRight = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            startTimeListLeft.add(A.get(i));
            endTimeListLeft.add(B.get(i));
        }
        for (int i = m+1; i <= r; i++) {
            startTimeListRight.add(A.get(i));
            endTimeListRight.add(B.get(i));
        }
        int lenLeft = startTimeListLeft.size();
        int lenRight = startTimeListRight.size();
        int i = 0, j = 0, k = l;
        while( i < lenLeft && j < lenRight ) {
            int currEndLeft = endTimeListLeft.get(i);
            int currEndRight = endTimeListRight.get(j);
            int currStartLeft = startTimeListLeft.get(i);
            int currStartRight = startTimeListRight.get(j);
            if (currEndLeft < currEndRight) {
                B.set(k, currEndLeft);
                A.set(k, currStartLeft);
                i++;
            } else {
                B.set(k, currEndRight);
                A.set(k, currStartRight);
                j++;
            }
            k++;
        }
        while( i < lenLeft ) {
            B.set(k, endTimeListLeft.get(i));
            A.set(k, startTimeListLeft.get(i));
            i++;
            k++;
        }
        while( j < lenRight ) {
            B.set(k, endTimeListRight.get(j));
            A.set(k, startTimeListRight.get(j));
            j++;
            k++;
        }
    }

    public static void mergeSort1(ArrayList<Integer> A, ArrayList<Integer> B, int l, int m, int r) {
        ArrayList<Integer> leftStartList = new ArrayList<>();
        ArrayList<Integer> leftEndList = new ArrayList<>();
        ArrayList<Integer> rightStartList = new ArrayList<>();
        ArrayList<Integer> rightEndList = new ArrayList<>();

        for (int i = l; i <= m; i++) {
            leftStartList.add(A.get(i));
            leftEndList.add(B.get(i));
        }
        int lenLeft = leftEndList.size();
        for (int i = m + 1; i <= r; i++) {
            rightStartList.add(A.get(i));
            rightEndList.add(B.get(i));
        }
        int lenRight = rightEndList.size();

        int i = 0, j = 0, k = l;
        while (i < lenLeft && j < lenRight) {
            int currLeftStart = leftStartList.get(i);
            int currLeftEnd = leftEndList.get(i);
            int currRightStart = rightStartList.get(j);
            int currRightEnd = rightEndList.get(j);
            if (currLeftStart < currRightStart) {
                A.set(k, currLeftStart);
                B.set(k, currLeftEnd);
                i++;
            } else if (currLeftStart == currRightStart) {
                if (currLeftEnd < currRightEnd) {
                    A.set(k, currLeftStart);
                    B.set(k, currLeftEnd);
                    i++;
                } else {
                    A.set(k, currRightStart);
                    B.set(k, currRightEnd);
                    j++;
                }
            } else {
                A.set(k, currRightStart);
                B.set(k, currRightEnd);
                j++;
            }
            k++;
        }
        while (i < lenLeft) {
            A.set(k, leftStartList.get(i));
            B.set(k, leftEndList.get(i));
            i++;
            k++;
        }
        while (j < lenRight) {
            A.set(k, rightStartList.get(j));
            B.set(k, rightEndList.get(j));
            j++;
            k++;
        }
    }
}
