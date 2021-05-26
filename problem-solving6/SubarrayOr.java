import java.util.ArrayList;

public class SubarrayOr {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 7,8,9,10 };
        // int[] arr = { 347148, 221001, 394957, 729925, 276769, 40726, 552988, 29952,
        // 184491, 146773, 418965, 307, 219145,
        // 183037, 178111, 81123, 109199, 683929, 422034, 346291, 11434, 7327, 340473,
        // 316152, 364005, 359269,
        // 170935, 105784, 224044, 22563, 48561, 165781, 9329, 357681, 169473, 175031,
        // 605611, 374501, 6607,
        // 329965, 76068, 836137, 103041, 486817, 195549, 107317, 34399, 56907, 37477,
        // 189690, 36796, 376663,
        // 39721, 177563, 174179, 183646, 217729, 408031, 429122, 631665, 282941,
        // 526797, 262186, 306571, 63613,
        // 57501, 70685, 226381, 1338, 9360, 130360, 20300, 400906, 87823, 180349,
        // 108813, 18181, 119185, 1,
        // 102611, 63591, 12889, 311185, 383896, 8701, 76077, 75481, 386017, 153553,
        // 304913, 383455, 105948,
        // 142885, 1, 12610, 137005, 119185, 16948, 66171, 123683 };
        int[] arr = { 68545, 260786, 1, 29565, 29695, 24193, 114797, 240479, 46076, 403900, 36502, 133043, 249601,
                383845, 783681, 517539, 71023, 64414, 260785, 87097, 158803, 869131, 359079, 43321, 84617, 5269, 3961,
                74089, 302933, 632476, 9799, 62305, 161839, 190323, 119680, 483133, 403789, 53401, 1, 20608, 285969,
                9790, 353266, 1171, 23371, 125489, 63870, 29825, 148627, 150970, 101005, 591057, 13876, 222667, 389993,
                362701, 67555, 94498, 473685, 220024, 364414, 194635, 297136, 40353, 525031, 552817, 315371, 23815,
                10737, 194619, 56616, 4506, 9697, 30241, 100829, 200719, 367173, 335665, 21313, 62670, 15751, 34019,
                72997, 592389, 1273, 513541, 29206, 714919, 593629, 273225, 861736, 428679, 7251, 339879, 81537, 199717,
                11449, 266311, 721840, 147187 };

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(sumOrSubarrays(A));
    }

    public static int sumOrSubarrays(ArrayList<Integer> A) {
        int len = A.size();
        int max = Integer.MIN_VALUE;
        ArrayList<String> binaries = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            String binary = getBinary(curr);
            binaries.add(binary);
            if (max < curr) {
                max = curr;
            }
        }

        int maxBinaryLen = getBinaryLen(max);

        int bitLen = 32;
        long totalSubarraysPossible = getSubarrayCount(len);
        ArrayList<Long> subarraysWithOnes = new ArrayList<>();
        int startIndex = bitLen - maxBinaryLen;
        
        for (int i = startIndex; i < bitLen; i++) {
            int countOfZeroes = 0;
            long sumTotalSubarraysZeroes = 0;

            for (int j = 0; j < len; j++) {
                char curr = binaries.get(j).charAt(i);
                if (curr == '0') {
                    countOfZeroes++;
                } else {
                    if (countOfZeroes > 0) {
                        long subarrayWithZeroes = getSubarrayCount(countOfZeroes);
                        sumTotalSubarraysZeroes += subarrayWithZeroes;
                    }
                    countOfZeroes = 0;
                }
            }
            if (countOfZeroes > 0) {
                sumTotalSubarraysZeroes += getSubarrayCount(countOfZeroes);
            }
            subarraysWithOnes.add(totalSubarraysPossible - sumTotalSubarraysZeroes);
        }

        long ans = 0;
        for (int i = 0; i < maxBinaryLen; i++) {
            long subarrayWithOne = subarraysWithOnes.get(i);
            long curr = (long)(subarrayWithOne);
            int dec = getDecimal(maxBinaryLen - i);
            long decimal = (long)(dec);
            long val = (curr * decimal) % 1000000007;
            ans += val;
        }
        return (int)(ans % 1000000007);
    }

    private static String getBinary(int num) {
        StringBuilder binary = new StringBuilder();
        while (num > 0) {
            // A odd number always has lowest order bit as 1
            if ((num & 1) == 1) {
                binary.append(1);
            } else {
                binary.append(0);
            }
            num >>= 1;
        }

        int len = binary.length();
        int bitLen = 32;
        // int bitLen = maxBinaryLen;
        int leftLen = bitLen - len;
        for (int i = 0; i < leftLen; i++) {
            binary.append(0);
        }

        int lenHalf = bitLen / 2;
        for (int i = 0; i < lenHalf; i++) {
            char curr = binary.charAt(i);
            char rev = binary.charAt(bitLen - 1 - i);
            binary.setCharAt(i, rev);
            binary.setCharAt(bitLen - 1 - i, curr);
        }
        return new String(binary);
    }

    private static long getSubarrayCount(int num) {
        // return (long)((num * (num + 1)) / 2);
        int num1 = num+1;
        long x = 1l * num1 * num; 
        return x / 2;
    }

    private static int getBinaryLen(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num >>= 1;
        }
        return count;
    }

    private static int getDecimal(int num) {
        return 1 << (num - 1);
    }
}

// public static int sumOrSubarrays(ArrayList<Integer> A) {
//     int len = A.size();
//     int max = Integer.MIN_VALUE;
//     ArrayList<String> binaries = new ArrayList<>();

//     for (int i = 0; i < len; i++) {
//         int curr = A.get(i);
//         if (max < curr) {
//             max = curr;
//         }
//     }

//     int maxBinaryLen = getBinaryLen(max);

//     for (int i = 0; i < len; i++) {
//         int curr = A.get(i);
//         String binary = getBinary(curr, maxBinaryLen);
//         binaries.add(binary);
//     }

//     // int bitLen = 32;
//     int totalSubarraysPossible = getSubarrayCount(len);
//     ArrayList<Integer> subarraysWithOnes = new ArrayList<>();
//     // int startIndex = bitLen - maxBinaryLen;
//     for (int i = 0; i < maxBinaryLen; i++) {
//         int countOfZeroes = 0;
//         int sumTotalSubarraysZeroes = 0;

//         for (int j = 0; j < len; j++) {
//             char curr = binaries.get(j).charAt(i);
//             if (curr == '0') {
//                 countOfZeroes++;
//             } else {
//                 if (countOfZeroes > 0) {
//                     int subarrayWithZeroes = getSubarrayCount(countOfZeroes);
//                     sumTotalSubarraysZeroes += subarrayWithZeroes;
//                 }
//                 countOfZeroes = 0;
//             }
//         }
//         if (countOfZeroes > 0) {
//             sumTotalSubarraysZeroes += getSubarrayCount(countOfZeroes);
//         }
//         subarraysWithOnes.add(totalSubarraysPossible - sumTotalSubarraysZeroes);
//     }

//     long ans = 0;
//     for (int i = 0; i < maxBinaryLen; i++) {
//         long curr = subarraysWithOnes.get(i);
//         long decimal = getDecimal(maxBinaryLen - i);
//         long val = (curr * decimal) % 1000000007;
//         ans += val;
//     }
//     return (int)(ans % 1000000007);
// }
