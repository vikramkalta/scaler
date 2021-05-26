import java.util.ArrayList;

public class MinAbsoluteDifference {
    public static void main(String args[]) {
        // int[] arrA = { 1, 4, 5, 8, 10 };
        // int[] arrB = { 6, 9, 15 };
        // int[] arrC = { 2, 3, 6, 6 };
        // int[] arrA = { -1 };
        // int[] arrB = { -2 };
        // int[] arrC = { -3 };
        // int[] arrA = { 1, 4, 5, 8, 10 };
        // int[] arrB = { 6, 9, 10 };
        // int[] arrC = { 2, 3, 6, 10 };
        int[] arrA = { 52, 94, 109, 149, 186, 214, 218, 235, 236, 285, 324, 352, 390, 393, 409, 445, 485, 498, 545, 582, 625, 630, 643, 657, 690, 731, 757, 783, 806, 807, 856, 895, 895, 916, 944, 987, 997, 1033, 1054, 1084, 1110, 1140, 1150, 1176, 1208, 1231, 1237, 1239, 1261, 1307, 1336, 1374, 1394, 1429, 1457, 1503, 1529, 1542, 1547, 1571, 1591, 1624, 1629, 1671, 1687, 1723, 1743 };
        int[] arrB = { -255, -245, -218, -206, -181, -157, -113, -84, -41, -40, -37, 12, 22, 68, 98, 132, 153, 188, 203, 209, 255, 284, 294, 307, 336, 336, 368, 406, 443, 459, 488, 532, 563, 578, 619, 630, 648, 653, 657, 698, 729, 757, 759, 805, 836, 862, 886, 912, 931, 962, 990, 1033, 1067, 1114, 1149, 1186, 1225, 1274, 1287, 1287, 1321, 1361, 1392, 1430, 1435, 1459, 1491, 1503, 1530, 1552, 1598, 1626, 1638, 1658, 1697, 1710, 1748, 1793, 1798, 1798, 1822, 1854, 1871, 1906, 1918, 1961, 1971, 2016, 2052, 2080, 2112, 2137, 2158, 2177, 2202 };
        int[] arrC = { 24, 49, 62, 78, 91, 135, 136, 136, 185, 213, 221, 231, 265, 276, 292, 311, 311, 341, 341, 375, 403, 424, 462, 490, 514, 553, 575, 618, 629, 658, 667, 701, 747, 761, 778, 814, 837, 844, 867, 913, 943, 951, 984, 1026, 1034, 1060, 1066, 1070, 1089, 1121, 1126, 1141, 1188, 1225, 1236, 1270, 1278, 1313, 1335, 1362, 1401, 1406, 1429, 1457, 1487, 1527, 1551, 1600, 1619, 1667, 1712, 1751, 1782, 1831, 1870, 1892, 1905, 1926, 1948, 1975, 2006, 2036, 2060, 2079 };
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < arrA.length; i++)
            A.add(arrA[i]);
        for (int i = 0; i < arrB.length; i++)
            B.add(arrB[i]);
        for (int i = 0; i < arrC.length; i++)
            C.add(arrC[i]);
        System.out.println(minAbsoluteDiff(A, B, C));
    }

    public static int minAbsoluteDiff(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int lenA = A.size();
        int lenB = B.size();
        int lenC = C.size();
        int iA = 0, iB = 0, iC = 0;
        int maxMinDiff = Integer.MAX_VALUE;

        while (true) {
            int a = A.get(iA);
            int b = B.get(iB);
            int c = C.get(iC);
            int max = max(a, b, c);
            int min = min(a, b, c);
            int diff = max - min;
            if (maxMinDiff > diff) {
                maxMinDiff = diff;
            }
            int minIndex = minIndex(a, iA, lenA, b, iB, lenB, c, iC, lenC);
            if (minIndex == -1) {
                break;
            }
            if (minIndex == 0) {
                iA++;
            } else if (minIndex == 1) {
                iB++;
            } else {
                iC++;
            }
        }

        return maxMinDiff;
    }

    private static int max(int A, int B, int C) {
        if (A >= B && A >= C) {
            return A;
        }
        if (B >= A && B >= C) {
            return B;
        }
        return C;
    }
    private static int min(int A, int B, int C) {
        if (A <= B && A <= C) {
            return A;
        }
        if (B <= A && B <= C) {
            return B;
        }
        return C;
    }
    private static int minIndex(int A, int iA, int lenA, int B, int iB, int lenB, int C, int iC, int lenC) {
        boolean isAExhausted= false;
        boolean isBExhausted= false;
        boolean isCExhausted=false;
        if (A <= B && A <= C) {
            if (iA == lenA - 1) {
                isAExhausted = true;
            } else {
                return 0;
            }
        }
        if (B <= A && B <= C) {
            if (iB == lenB - 1) {
                isBExhausted = true;
            } else {
                return 1;
            }
        }
        if (iC == lenC -1){
            isCExhausted = true;
        } else {
            return 2;
        }
        return -1;
    }

// if (isAExhausted) {
        //     if (B >= C) {
        //         return 1;
        //     } else {
        //         return 2;
        //     }
        // } else if (isBExhausted) {
        //     if (A >= C) {
        //         return 0;
        //     } else {
        //         return 2;
        //     }
        // } else if (isCExhausted) {
        //     if (A >= B) {
        //         return 0;
        //     } else {
        //         return 1;
        //     }
        // }
    public static int minAbsoluteDiff1(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int lenA = A.size();
        int lenB = B.size();
        int lenC = C.size();

        int iA = 0, iB = 0, iC = 0;
        int maxMinDiff = Integer.MAX_VALUE;
        while (true) {
            if (iC == 84) {
                break;
            }
            int currA = A.get(iA);
            int currB = B.get(iB);
            int currC = C.get(iC);

            int min = 0;
            int max = 0;
            if (currA > currB) {
                max = currA;
                min = currB;
                if (min >= currC) {
                    min = currC;
                    if (iC < lenC - 1) {
                        iC++;
                    } else {
                        if (currA > currB && iB < lenB - 1) {
                            iB++;
                        } else {
                            // iA++;
                            if (iA < lenA - 1) {
                                iA++;
                            }
                        }
                    }
                } else {
                    if (iB < lenB - 1) {
                        iB++;
                    } else {
                        if (currC > currA && iA < lenA - 1) {
                            iA++;
                        } else {
                            if (iC < lenC - 1) {
                                iC++;
                            }
                        }
                    }
                }
                if (max < currC) {
                    max = currC;
                }
            } else {
                max = currB;
                min = currA;
                if (min >= currC) {
                    min = currC;
                    if (iC < lenC - 1) {
                        iC++;
                    } else {
                        if (currA > currB && iB < lenB - 1) {
                            iB++;
                        } else {
                            if (iA < lenA - 1) {
                                iA++;
                            }
                        }
                    }
                } else {
                    if (iA < lenA - 1) {
                        iA++;
                    } else {
                        if (currC > currB && iB < lenB - 1) {
                            iB++;
                        } else {
                            if (iC < lenC - 1) {
                                iC++;
                            }
                            
                        }
                    }
                }
                if (max < currC) {
                    max = currC;
                }
            }

            if (iC >= lenC - 1 && iB >= lenB - 1 && iA >= lenA - 1) {
                currA = A.get(lenA - 1);
                currB = B.get(lenB - 1);
                currC = C.get(lenC - 1);
                if (currA > currB) {
                    min = currB;
                    max = currA;
                    if (min > currC) {
                        min = currC;
                    }
                    if (max < currC) {
                        max = currC;
                    }
                } else {
                    min = currA;
                    max = currB;
                    if (min > currC) {
                        min = currC;
                    }
                    if (max < currC) {
                        max = currC;
                    }
                }
                int diff = max - min;
                if (maxMinDiff > diff) {
                    maxMinDiff = diff;
                }
                break;
            }

            int diff = max - min;
            if (maxMinDiff > diff) {
                maxMinDiff = diff;
            }
            if (maxMinDiff == 0) {
                break;
            }
        }
        return maxMinDiff;
    }
}
