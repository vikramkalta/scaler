package string;
public class CountOccurence {
    public static void main(String args[]) {
        // String A = "abobc";
        String A = "bobob";
        System.out.println(occurence(A));
    }

    public static int occurence(String A) {
        int len = A.length();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                char curr = A.charAt(j);

                sb.append(curr);
                if (sb.toString().equals("bob")) {
                    count++;
                    break;
                }
            }
            sb.delete(0, sb.length());
        }
        return count;
    }
}
