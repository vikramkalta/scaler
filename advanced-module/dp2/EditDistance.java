public class EditDistance {
    public static void main(String args[]) {
        String A = "abcd";
        String B = "bcad";
        // StringBuilder a = new StringBuilder("1");StringBuilder b = new
        // StringBuilder("1");
        // System.out.println(a.toString().equals(b.toString()));
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {
        // StringBuilder a = new StringBuilder(A);
        // StringBuilder b = new StringBuilder(B);
        // int max = Integer.MIN_VALUE;
        int ans = getEditDist(A,B,A.length()-1,B.length()-1,0);
        return ans;
    }

    public static int getEditDist(String A, String B, int i, int j, int ans) {
        // Base case
        if (A.equals(B)) {
            return 0;
        }
        if (j < 0) {
            return i + 1;
        }
        if (i < 0) {
            return j + 1;
        }
        
        if (A.charAt(i) == B.charAt(j)) {
            ans = getEditDist(A, B, i - 1, j - 1, ans);
        } else {
            int x = getEditDist(A, B, i, j - 1, ans); // add
            int y = getEditDist(A, B, i - 1, j, ans); // delete
            int z = getEditDist(A, B, i - 1, j - 1, ans); // replace
            // ans = Math.min(getEditDistance(A, B, i, j, ans), getEditDistance(A, B, i, j, ans));
            int min = Math.min(x, y);
            ans += Math.min(min, z);
        }
        return ans;
    }

    public static int getEditDistance(StringBuilder A, StringBuilder B, String ogA, String ogB, int ans) {
        if (A.toString().equals(B.toString())) {
            A = new StringBuilder(ogA);
            B = new StringBuilder(ogB);
            return ans;
        }
        int lenA = A.length();
        int lenB = B.length();
        if (lenA > 0 && lenB > 0 && A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            StringBuilder a = A.deleteCharAt(lenA - 1);
            StringBuilder b = B.deleteCharAt(lenB - 1);
            ans = getEditDistance(a, b, ogA, ogB, ans);
        } else {
            if (lenB > 0) {
                // insert
                StringBuilder insertedStr = add(A, B);
                ans = getEditDistance(insertedStr, B, ogA, ogB, ans + 1);
                // replace
                StringBuilder replacedStr = replace(A, B);
                ans = getEditDistance(replacedStr, B, ogA, ogB, ans + 1);
            } else {
                // delete
                StringBuilder deletedStr = delete(A);
                ans = getEditDistance(deletedStr, B, ogA, ogB, ans + 1);
            }
        }
        return ans;
    }

    public static StringBuilder add(StringBuilder A, StringBuilder B) {
        char bEnd = B.charAt(B.length() - 1);
        A.append(bEnd);
        return A;
    }

    public static StringBuilder replace(StringBuilder A, StringBuilder B) {
        char bEnd = B.charAt(B.length() - 1);
        A.deleteCharAt(A.length() - 1);
        A.append(bEnd);
        return A;
    }

    public static StringBuilder delete(StringBuilder A) {
        A.deleteCharAt(A.length() - 1);
        return A;
    }
}
