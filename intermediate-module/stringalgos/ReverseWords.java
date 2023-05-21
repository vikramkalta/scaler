package stringalgos;

public class ReverseWords {
    public static void main(String[] args) {
        // String s = "the sky is blue";
        String s = "a good   example ";
        // String s = " bjwapykfil ymg bsypbqu rp nnvwwx muiapt pfwlcsnkqz mazvb hncn ya qisjiabv wnzjh w eimspekey rfmy bwroafq ";
        System.out.println(solve(s));
    }

    public static String solve(String A) {
        A = A.trim();
        A = A.replaceAll(" +", " ");
        String[] a = A.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            String curr = a[i];
            ans.append(curr);
            if (i != 0) {
                ans.append(" ");
            }
        }
        return new String(ans);
    }
}
