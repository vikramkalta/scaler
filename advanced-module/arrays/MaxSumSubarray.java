import java.util.ArrayList;

public class MaxSumSubarray {
    public static void main(String args[]) {
        // int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arr = { 1,2,3,4,-10 };
        // int[] arr = {-163, -20, -10};
        // int[] arr = {-500};
        int[] arr1= {-120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428,
        -182, -138, -167, -465, -347, -39, -51, -61, -491, -216, -36, -281, -361,
        -271, -368, -122, -114, -53, -488, -327, -182, -221, -381, -431, -161, -59,
        -494, -406, -298, -268, -425, -88, -320, -371, -5, 36, 89, -194, -140, -278,
        -65, -38, -144, -407, -235, -426, -219, 62, -299, 1, -454, -247, -146, 24, 2,
        -59, -389, -77, -19, -311, 18, -442, -186, -334, 41, -84, 21, -100, 65, -491,
        94, -346, -412, -371, 89, -56, -365, -249, -454, -226, -473, 91, -412, -30,
        -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429, -215, -102, -63,
        80, 65, 63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68, -472, -463,
        -212, -267, -302, -471, -245, -165, 43, -288, -379, -243, 35, -288, 62, 23,
        -444, -91, -24, -110, -28, -305, -81, -169, -348, -184, 79, -262, 13, -459,
        -345, 70, -24, -343, -308, -123, -310, -239, 83, -127, -482, -179, -11, -60,
        35, -107, -389, -427, -210, -238, -184, 90, -211, -250, -147, -272, 43, -99,
        87, -267, -270, -432, -272, -26, -327, -409, -353, -475, -210, -14, -145,
        -164, -300, -327, -138, -408, -421, -26, -375, -263, 7, -201, -22, -402,
        -241, 67, -334, -452, -367, -284, -95, -122, -444, -456, -152, 25, 21, 61,
        -320, -87, 98, 16, -124, -299, -415, -273, -200, -146, -437, -457, 75, 84,
        -233, -54, -292, -319, -99, -28, -97, -435, -479, -255, -234, -447, -157, 82,
        -450, 86, -478, -58, 9, -500, -87, 29, -286, -378, -466, 88, -366, -425, -38,
        -134, -184, 32, -13, -263, -371, -246, 33, -41, -192, -14, -311, -478, -374,
        -186, -353, -334, -265, -169, -418, 63, 77, 77, -197, -211, -276, -190, -68,
        -184, -185, -235, -31, -465, -297, -277, -456, -181, -219, -329, 40, -341,
        -476, 28, -313, -78, -165, -310, -496, -450, -318, -483, -22, -84, 83, -185,
        -140, -62, -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2,
        81, -326, -339, -56, -123, 10, -463, 41, -458, -409, -314, -125, -495, -256,
        -388, 75, 40, -37, -449, -485, -487, -376, -262, 57, -321, -364, -246, -330,
        -36, -473, -482, -94, -63, -414, -159, -200, -13, -405, -268, -455, -293,
        -298, -416, -222, -207, -473, -377, -167, 56, -488, -447, -206, -215, -176,
        76, -304, -163, -28, -210, -18, -484, 45, 10, 79, -441, -197, -16, -145,
        -422, -124, 79, -464, -60, -214, -457, -400, -36, 47, 8, -151, -489, -327,
        85, -297, -395, -258, -31, -56, -500, -61, -18, -474, -426, -162, -79, 25,
        -361, -88, -241, -225, -367, -440, -200, 38, -248, -429, -284, -23, 19, -220,
        -105, -81, -269, -488, -204, -28, -138, 39, -389, 40, -263, -297, -400, -158,
        -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230, -410, -66, 67,
        -396, -146, -158, -264, -13, -15, -425, 58, -25, -241, 85, -82, -49, -150,
        -37, -493, -284, -107, 93, -183, -60, -261, -310, -380};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(maxSum(A));
    }

    public static int maxSum(ArrayList<Integer> A) {
        int len = A.size();
        if (len == 1) return A.get(0);

        ArrayList<Integer> prefix = new ArrayList<>();

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            sum += curr;
            prefix.add(sum);
            if (curr > max) {
                max = curr;
            }
        }

        ArrayList<Integer> maxRight = new ArrayList<>();
        ArrayList<Integer> minLeft = new ArrayList<>();

        int _maxRight = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            int curr = prefix.get(i);
            if (_maxRight < curr) {
                _maxRight = curr;
            }
            maxRight.add(_maxRight);
        }

        int _minLeft = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = prefix.get(i);
            if (_minLeft > curr) {
                _minLeft = curr;
            }
            minLeft.add(_minLeft);
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int right = maxRight.get(len - 1 - i);
            int left = minLeft.get(i);
            int diff = right - left;
            if (maxDiff < diff) {
                maxDiff = diff;
            }
        }
        return maxDiff == 0 ? max : maxDiff;
    }

    public static int maxSum2(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            int sum = currI;
            if (currI > max) {
                max = sum;
            }
            for (int j = i + 1; j < len; j++) {
                int currJ = A.get(j);
                sum += currJ;
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSum1(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Integer> prefix = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            sum += curr;
            prefix.add(sum);
        }

        ArrayList<Integer> sign = new ArrayList<>();
        sign.add(0);
        for (int i = 1; i < len; i++) {
            int curr = prefix.get(i);
            int prev = prefix.get(i - 1);
            if (curr <= prev) {
                sign.add(-1);
            } else {
                sign.add(0);
            }
        }

        int count = 0;
        int lowerIndex = -1;
        int highIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = sign.get(i);
            if (curr == 0) {
                if (count == 0) {
                    lowerIndex = i;
                }
                count++;
            } else {
                if (lowerIndex > -1 && count > 0) {
                    highIndex = i - 1;
                    int diff = prefix.get(highIndex) - prefix.get(lowerIndex);
                    if (diff > max) {
                        max = diff;
                    }
                    lowerIndex = -1;
                    highIndex = -1;
                }
                count = 0;
            }
        }

        return max;
    }
}
