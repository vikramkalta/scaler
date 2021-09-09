public class StringMatch {
    public static void main(String args[]) {
        System.out.println(solve("xywrrmp", "xywrrmu#p"));
        System.out.println(solve("xy#z", "xyz#"));
        // solve("xywrrmp", "xywrrmu#p")
    }

    public static boolean solve(String A, String B) {
        int a = A.length()-1, b = B.length()-1;
        
        while(a>=0 || b>=0) {
            int a1 = getNextValidIndex(A, a);
            int b1 = getNextValidIndex(B, b);
            if (a1<0 && b1<0) {
                return true;
            }
            if (a1<0 || b1<0) {
                return false;
            }
            if (A.charAt(a1)!=B.charAt(b1)) {
                return false;
            }
            a = a1-1;
            b = b1-1;
        }
        
        return true;
    }
    
    private static int getNextValidIndex(String str, int index) {
        int backspace = 0;
        while (index>= 0) {
            if (str.charAt(index) == '#') {
                backspace++;
            }else if (backspace>0){
                backspace--;
            }else{
                break;
            }
            index--;
        }
        return index;
    }
}