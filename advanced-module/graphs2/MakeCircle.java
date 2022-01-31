import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MakeCircle {
    public static void main(String args[]) {
        // String[] arr = { "aab", "bac", "aaa", "cda" };
        // String[] arr = { "g", "ggfhhgfi", "ihifhhgf" };
        // String[] arr = {"fifhgfhg", "hiihihg", "iii"};
        // String[] arr = { "zaz", "zbz", "zaz", "zdz" };
        String[] arr = {
            "eccedbedbbbdcddebcccddaabdbbaeadcbddeebedcdbdeedaabaacdcdbbecdcdaeaaadccddccddcdcbbcdbceaddbbcededbccaaeaaeeaab", "dabddaedabcddbecacbcddcbcaedabcbcebeabbcdebdbdaddcdbeceaeadbebceceaecedcbaaaedacdbedbabdadcbbbcacebdbeccaaeddcbdb", "cadeabeeccbaeceacdabdaabaeaeeeccbddaeaceeaecdacdedcdaaedaceeaadaaeaecbaabdaadbecdaeaaacecddecacbbdbeeaadacaaaaedcdceeaabddabcebbcdaedaeeebedbccddeebad", "aeeceeecadcaedbebeaaccaceabcdabccadeeaadadaacaaecbddaabeedcacbcbeabdccadedeabdaceeccbaeddacbbeaebadabcabee", "cddeeecdecacdbcabbdeaeabdbcbbabbaadbceeebdcdcbaceabbedacddeadeececaceedddccabdddaccabeacaacccdaacecededbdeedaadbebdadacadaaaaeebaacbbacbaeddbb", 
            "dbceebdbdaaeabeaeceaaebbcbcbedacbeacdebbacceadeaadcbedebdadcccacdcabaeebaceeadbccddacadeccdbaacdbccceacbaaeabbaecbdeabecaee", "beecdccdebecbddeabcaceecbbbcaedebbecadabebeebaeedeeccbeedebdaddabbecdcbbeadebdabcbdabcdabadcdbeeedeeeceebbededaecbaabccc", "ceccaebebdebdbdeceebcbaddebebaaacaeaeaeebbcbeeaecdcbbadccdeabdaeadebcbeddabeaebbcceeeeecbcdadaaaeababdedbdbeddededddcbdbebceaeaeddcdabaa", "cedbaaaabbaddbeabddadeecdadddabebcbecdbdeceebecdccadaabcacecccdccaeddbcbbdeeebbeeecdeeaddbeadbecabeaeacecdcaceadcaebedddbbadbaaebdbce", "dacbabeedcaccceaacdacaeceedbcbbebdbaeaebabecbdbbaeabbcccdbcbacbccaddacbcddbbdecbeaacebabcaecaacbdeaadcaddbdabbceaeca", 
            "eebeaceceeacedbddabecdccbadacaeabbdaacccaeedacdceeaacadbcceacddcccaadabccdebcbdeccbeddaedcaabbecdbbaececdadcedabdabececbecadeccecabcadeeaeeeddcbeecadc", "daaadadeceaecbabbebbebdedcbcbeaceaedaeecbecadacecdaedccaecebcedcdddcdabcbbcdcdbaebebaadaeadccbdeaeaaecaaccbeaede", "bceadeceebbedceddbcdbceeddedbccdddabacaeeedcbaeebceedcbeabecababccebbacbceacecbbccaabaecbebaccddbbbaeccbcaceaddedaadddecadcbcabebaacebdeae", "bdddcbaabdaeddadceebaecaccacceadebecdebdbabebdddbaeeebacabceacaaacdaceceaaceadaeeabaeeeaaabebccbaadcecebdbccdaaba", "edaeccebbedbadcaadccbddbbadcbedeccbdcaecceaadcecdabbecedeebcbcaebcdadabebceccabdcebdaebdcbdeadcebcccdacdacdbebceabceebdeaacabbedcebacee", "babacacaaedecbbcdcbacdaacadbcdeedcadcaeabbbaaecdaecdddaedcdacacbdbcbccbedeccacdedcbeeaadadbdcedceceaaaddacdbaceaaeeeecdabccddaaaebebbadbaeaae", "dbecababaedbdaabaaecacededddbacebaacdbaddeedabbddddcaddbadabaebdbeeeeecdbacdacaeeadcaccacbbabebbdbabeebcccbaaadeccdcbeddacdceeaabadbabaedcdaecdbedba", "ebedebabccdeedeacceddbacabcdecaccdeacbebcbbeebbdaadabaceddeaeeeeacbbdeceaabdedabcdcbdebdabbeaebdcebeeeeccbecddadc", "ccadbcdecdaebbbacebebbcbcbcccaedcdbdaecacaadbdaddabeebaeeebcdacaeaabdebeaaaaedaebbbaaeddcdcaebcdecbdcdcbdabcaeedbbddccddddecebabddabaebebabacccacccdaaec", "dadcbdedaaececadcdecdeadbbcedbdcdadcceacbedbebbdeaebeabcebdedcbddbbdeeebadccbaadcdcedadbaedbedeeeebbcddadccabecebdaaeceaadececcdcbdbeebecbdabebbad", "daccddbdaddceebceabaedddeeecadaebdbebaebabadacedeeaccccddedcceadedacadddaadbccaaabbcccbadebadebdaebbbcaaadbdcadaaccbadcbebbeacccdd", "cdaabbadecbbadbdbccedcbaacdcaadeedaddbbbccdeedebcceeabacccabceabdcabcbeeacccdebabaedbdddaacecabaedbecdddeeaadebbacaedecdaacaaae", "dadbdddbcbdeeeadeddadaaebaeeebcedabeacdcbccbbbaeeabeededceaaeaebcaddbbaedbadabccdbbbcebdacaedabebabdedcebecb", "bedddcecedbceebbeebedaacaeaceebcbaddacbdecaaeccbadaccdadaccdcaebbdeadccebcabdbdbdbcdabaedebcbacecacaedabcabcaaabadbeabcdeaaeaacbbaebbdededecaaaaabaceec", "beadeebcddcbbaedbdeccebbdbeaeeccecaedcaededdaeccccecbbbadaedceecadebecacaaededcdcaaacbcdaabbbddacaadaeeddabccbbaacbbebebeebdaebbaedcbbedcdbcb", "edaaedcebcbebacaaadabdabbabaacceaecedaccdeaebdabcdbebccbdaaedacbedbddbbdeaddbeabcedcdeeacdbedaedcdbebaa", "adedbebdebeceeabbdccedbeaadbbcbeebddeadedbdeaeeceabcabaadeabbedebedadabadbeecbaecceccbdbadeecbcacbcaddcdddddececb", "ccdeeabbcbaddaccaaeececeabdceaabdaabdaeeceedeadadccadedceeecadbaccbdeebbdabbaaeccabbeaddccebddedcdbcbccddbdbcbeac", "bcebabeabebcebcbecadcebaadbbcedacedececcadebcebbbeedbecedcadcabbedcbdcabdeedebbdedceebedeeeacbbccabdacacecebdeedbcdebcdbadaecbbebbeaebbcadbb", "deadebbcdbbebeaebebeccebdbbeadeddacbbceeecadddeedeaddedecdeaedcabbdaabaedbdeabeadcabedcdcaaccbdeadddadecacbddaecdbdaad", "bdaaddcdabaaecccdceeedcccadecdeabeacddbedbaeaceadbeaceaddcdcbaeacaeaabcaedebcddacbbacdedeeeecadcdcdacbecbebbadd", "becebaeabbdbddbaadeddededeebecccacdcddddacddbdabcadbaadeadaedaadaadedadbcbaccbbaabccdddabdcbeecdabedbbbddceeedaeecccabbeacaedbcdcabadab", "bcdebccbdeacacabdbcacbbeddaeacbbcaaebedeacbbddcdcbaabdccdedacdcababebddbdadabebbaaaddeedddbcdaddaedddbcb", "ceccdbddcebebaaaebcedaacdcabadecbbcdeabecaabadceabeedbcecaceecbcaeadddbeaacdeebeaeeeaaaadaaeeddcaecdbece", "daeddcbcbceabadceceeedecbeabacecbcbadbeededddcdcdecaebaedbddecbbaaeaaadccacacddccaabebbeeacaceecbdbeacb", "dbedbddedecccbcbbcdabacabaccaeaedcabaddbacacecdcccedbddbabdcbabceabbaebddaaecbddaceaedacddadadcbbadbdccdecdacdcaadbceeddccbceaadeabadecdceeeceea", "eddceecdcbdecccecacddcaeadbbbebcdcddabeccbbeceaabeebbdcddbcdaccedbebdabedacacadcaebacceadcccecebbeeaedcbabdbecbacdbadadecbbedbbebcaecacdeab", "acacbceacbbcabedcccedbceebadeeaacebeebbccbbdacdccaebeeaecddcebcadaaddbadaabbeebccabeeabdaedaeecacbaedbccdbacecdeaedcaccceccccbecddcbbeadebaadcaeebdad", "dbaedbabbdcacaeceadbeecdbccbdcaebddaddcbdedcebaaeacbebdeaddcbbccedbccebaebdeeedeabaeceabbabcccaacbdbabeedcadebcabaaebb", "cacedcbdaebdcabdaaaaccadbaacbdeeeaedcddecabcaeccbbdececcadeadaedcbdccdebcbcebbceddccdacdbccebebcbabeacdcceaadadcaddbdabdaeacecabcaeecaee", "aaeebeecdaaecbebeecdaabcdeaadbaaebcedacbeaeeebcdbcbddbaabbddaebccdabdbeadcadeddddcbcaabcadcecaebcccabaddabbeccaecaebedbecdbc",
            "accdecabbdeebeaeadbbcbbbceeedbbabaaadddeddecceaccbeedcbebedcdadcbedccccececabdcdeacbacecaeeadbecebdcdeedabacbebeacacaeceddacaebaccc", "bdabebeddbebbaeaaabbdcabebabddacbaaebccaabcabedbbcbcedeccbbaaeaeecaedeaacdbaabacaebbebbedeaabcbcdccdacaabbedcbbaacecabdbaabacdcbeaebecbdbcdaa", "caaeadcaeabeeacdaaebcbccaedadaaccccaecacccabebcabdebcbaecdcaedaceccddeadaebdbdcdaeddcbbebaebbeddecdcdbbcadaeedebabaabeb", "abebbbecdccbdeeecadecadeacaebeeceeedbdeddcceadedbbbbbeebaaeaecddaaabdbbcceebbeebacdbaccbeecaaeadabbcabcaacbded", "eddbadabdecedeeceecbdebcaaaaedbcacccbccddcdbadcebbeabaddacdcdbccecdaccbabaecaccaacccbaaeccecebceaeaccbeb", "ddedaededcdbeaddbbadeabdebbcdbdaccbcecdeeddecedecbebbababcedaeaeacceddcbadacbcacecdadabbabdcddeadbbbacbba", "eebcddacaaeebeccaadeadebbececedceaeceacccccacdbcedeccacbcddcedcbccaebecdcaccbecbcbeaccecebabcbdaaaabcebccaacabcbbbdbcaebbdcaedcdbaeebcbadb", "dadadaabebddaddccccdaddcccaecadebdaeeecbeeaeaecdceaadcddeaddbbcdcddccabeccbaedcaaaeeabecceaeaadbeebbccbdecaaacacdcbeeaddaddcdedcbcadadedbcbcbacc", "ddbacbbcebcccbcbcabecddbadbbaeaabdaedeecadabeadcbcbbbebcccabdbddabcdbbabbbaaaeddbcacaccceaeecbdbabcaaceaacecbbdacbddeebb", "eadbcaccbabdbeedaadcdcdbebcbcddebeeabceceaedcbdadaaebcddcbdddeaebabaacdecbebabbcbaeebbdabacbecedddccdeaaaddbbcbd", "edcaabbdebccceeeceabbcdbddddecadcedbcbeabdebdbbcdaddcdececabeeddacbccdebdadcdcedcecceebdbcdedeaabecddcaeacabacdebaeccdabbbebbdeddabbcbbedd", "daeedcdbcceddcdebccccdcebeaeadeddaaebadbdbdbacdecbaadbeaabdeddeedbabbcabddaacaeccbaacdaeacabddcadbccabbceecacecbbbebceabebdeccdcabd", "ceaccaadeddeeabaaddaccbcbebaacddecdecbdcbcdccabaabcbddccdbdecabecdcebbdaeeedbbadadeeaecddabeaebaebdceedabcddbbbaacd", "beaacacabddbdccdecdaecbeccdabeeaeecccddbeebccbdddcdcdccbdbddddccbeebebdcceaedecedbeeecdbcbedacecaeddcccadbcbaecacbecaebe", "aecdcbecccbaceaeccbcedbeacdedcdcddeeaabbcdeedcccbacacabbbcabdbaedeceecdcaaeedeebdbaeedcbdcaecaabcdabeceb", "ecdecadbdbbadddbdcbeebceeccbeaaeacabcbdbbadadecedbcaedcbdebaadbeaaeddedddcaacaabacebceaaeeeecebebdabcddeaacaeeabcedebaade", "dedecccbcbaeecdeeaccccbdebaedacdeaaecabdbeeebbbcedbaeadcdcabcccebdaaaaabdadbecabcabcaebdaedcbaeceaecceaaaedaabb", "bedaabedaeadebedcddbbebebcebbdbebdebededcabdacaeadeaaeddcdbacaaabeaaadbdabeeaacdcebbcadaeabcbadbddedbccedcaeaaabebadcecabeacdaaaaedbcd", "ebebdeaabdbdaadaedbdbcdebbabceaecaeceadcdddbbbedbdedaabaeecceccabbaecbdbbbbaccbaecbedadeaeaccddabbddedebbbaebecddbcadbeeeaababee", "ddebcdcaedccedbaebebedcbabdaabdbdcebaddeedecabaaeecaaeabebdcedbdeeabbacbeccebedcdebdabbdeacbddcbeaeaebbdaaaedaeccebbedececaeeecbdceebcdbcbddbdededd", "ebcccebccbcdbedcbdabacaceddbdbdcccdadadceacbcbebdbcaaabccceaeeaadccbaebcebbdcdaadeeceaccddcdbbeebadcacdcdccdcaddcedcaddadcdbcbbdeebdeb", "cebeeebdecebeeedeeeaececdccedcbeeeaecebcdededeacddebdaebacccedbbaaeccbdaddadecbbebbadbccbebaacdbcdabbeadccebdeabbdeacddebbbbe", "dccbaacedbaaeeeeabdcddecacbcdeecbaeaddecebedaebceaebaecaddecdbdcaaeceeabdeaadccccebcdaeeeaaeeedcebdabeeadbed", "dcabbbcadabacbaeaeeaeeacacccdeacddaedccaaaaeaaeaaddcdcbcaadddddbdbccbbdacdadadcacccbcbedecbdbcdeaebaebcccdcbccaabdcedeeceeddadaabcdbccedeccdcabebbadeabc", "dcdbcbeabebbcbbaebcdddcaecbceadbdbecebddebaecbcadedcddbeaabcaaadebceaadceedaeecdeaaedbccbeabcaaecdcadecebcaa", "aadebccdeedadbabcaedababeddcdbdbbedcbdddaeaeeebeaacecdbebeebaddabaaabeccdabdbdddcacbcdabdccddcaecccbdecbeccdab", "cdcbedbebcabeeacecaecddbcdacbbdabababaedededeaaecbacedddaccaaacbedeebcabbbacdaeddcbdccdcbcdadeaadeaadecdadcbacedcdebbdceaedaabcdaadcadbeecaebbae", "ebbdaeeeaeebaedcdabdceebddbeacbeddeddbebabdddadcadaebeaaacaccedaeacebcecedbcbdbbcabccadddeabeabcdbbbbbddabedceededdabdabaad", "aaebbaaabaeecbebcabcadbbbeddeacabcacbcaadeecdedccabadeacbaaccaceeacdedcdaaeeddcdecadcdebabdcebdbabdacccacbcceaaacebdeaabadcadcecbccedebcdeeddbaabaccacd", "abdddcdedbebbebaebbdceeebeeebeacdbeeadcdcbcecbcaecceebeecccacbdaaedbaccbeacbdbaecbcbcbdabeccedeaeaccceacdcbecaebeaecd", "ababbbebecbdbcabaebcacbdcdbbadccddebcddaaaccbedaacdcbccdaedabcaacdaeeceaaddeaeddcbedddadeededabbaabaaeabcabbbbdcbbdbdcaaadaebbccaacaddecadb", "aedbdeecccbdcabeeaeeddebdecdbcccbdaccebdaabdccecaabeeecaddecaeaaebddeaaeecaabedcdcebdccaccadebabcaaecdcbaccdeabcbbbdadaddddaccbddeedaacdabd", "ceeacdebacdbbddcccbcbaeeebadbceaddbcbeedceaceedddbedbbcddcbccacdccdacadecdcaaaccbcdcdbbaeadeaaaccaacbedbebdeddaabaadeaaeccbeeeadadaacbc", "ccdddeebaebcccbabaadcbdcddeceeabdacabccaebebaabdddacababdebdddbcdcdceebedcabbcbeeacedebbadeaddaaceceaadecebdaebbcdbabaedecdebdaeecedbccccccdcddddbabe", "dcacadcedcbdceaaaaeeaeaddddacddececbddabdabdccbceddbadaddedebebedbecdbbebbaaeaabeaedaecabcbeacaabaccaabbdddeabdbeddecdaceabdacbecebdebedcecba", 
            "daaabeddaebddeacbebdcdecdddbaadadbedaeddcdbdbbddecbeedebbdbebbbdaabaadacdedebdeaddbbbdbcaabbeebceadecbdeecaebbadaaebcdeadd", "dcacbcadbbdedcbabcedadbccacceaeabbeabaccabeddeebcbaeebccabacbdacbedacaabeeeceddbeabcbaeedbeddecbebadcccddcba", 
            "aacbadabaaaaabdccaacdeaacbdc..."
        };
        ArrayList<String> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(solve(A));
    }

    private static HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
    private static char smallestChar;
    private static int[] visited = new int[26];
    // private static char lastVisitedChar;
    private static HashMap<Character, Integer> inDegree = new HashMap<>();
    private static HashMap<Character, Integer> outDegree = new HashMap<>();

    public static void createGraph(ArrayList<String> A) {
        int max = Integer.MAX_VALUE;
        for (int i = 0, len = A.size(); i < len; i++) {
            char vertex = A.get(i).charAt(0);
            char edge = A.get(i).charAt(A.get(i).length() - 1);

            int charCode = (int) vertex;
            if (charCode < max) {
                max = charCode;
                smallestChar = vertex;
            }
            
            if (graph.containsKey(vertex)) {
                graph.get(vertex).add(edge);
                if (outDegree.containsKey(vertex)) {
                    outDegree.put(vertex, outDegree.get(vertex) + 1);
                } else {
                    outDegree.put(vertex, 1);
                }
                if (inDegree.containsKey(edge)){
                    inDegree.put(edge, inDegree.get(edge) + 1);
                } else {
                    inDegree.put(edge, 1);
                }
            } else {
                ArrayList<Character> edges = new ArrayList<>();
                edges.add(edge);
                graph.put(vertex, edges);
                if (outDegree.containsKey(vertex)) {
                    outDegree.put(vertex, outDegree.get(vertex) + 1);
                } else {
                    outDegree.put(vertex, 1);
                }
                if (inDegree.containsKey(edge)){
                    inDegree.put(edge, inDegree.get(edge) + 1);
                } else {
                    inDegree.put(edge, 1);
                }
            }
        }
    }

    public static void dfs(char c) {
        visited[(int) c - 97] = 1;
        if (graph.containsKey(c)) {
            ArrayList<Character> edges = graph.get(c);
            for (int i = 0, len = edges.size(); i < len; i++) {
                char curr = edges.get(i);
                if (visited[(int) curr - 97] == 0) {
                    dfs(curr);
                }
            }
        }
    }

    public static int solve(ArrayList<String> A) {
        createGraph(A);
        for (int i = 0; i < 26; i++) {
            visited[i] = 0;
        }
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            char key = entry.getKey();
            int inDegreeCount = entry.getValue();
            int outDegreeCount = outDegree.getOrDefault(key, 0);
            if (inDegreeCount != outDegreeCount) {
                return 0;
            }
        }
        dfs(smallestChar);

        boolean ans = true;
        for (Map.Entry<Character, ArrayList<Character>> entry : graph.entrySet()) {
            char key = entry.getKey();
            if (visited[(int) key - 97] == 0) {
                ans = false;
            }
        }
        return ans ? 1 : 0;
    }

    // 1 for red, 2 for green;
    public static boolean detectCircle() {
        Queue q = new Queue(26);
        q.enqueue(smallestChar);
        visited[(int) smallestChar - 97] = 1;

        while (!q.isEmpty()) {
            char front = q.dequeue();
            ArrayList<Character> edges = graph.get(front);
            for (int i = 0, len = edges.size(); i < len; i++) {
                char curr = edges.get(i);
                if (visited[(int) curr - 97] != 0 && visited[(int) curr - 97] == visited[(int) front - 97]) {
                    return true;
                } else {
                    visited[(int) curr - 97] = visited[(int) front - 97] == 1 ? 2 : 1;
                }
            }
        }
        return false;
    }

    static class Queue {
        int length = 0, size = 0, rear = -1, front = 0;
        char[] q;

        Queue(int n) {
            q = new char[n];
            length = n;
        }

        public void enqueue(char n) {
            if (isFull()) {
                System.out.println("Illegal op[e]");
                System.exit(1);
            }
            rear = (rear + 1) % length;
            q[rear] = n;
            size++;
        }

        public char dequeue() {
            if (isEmpty()) {
                System.out.println("Illegal op[d]");
                System.exit(1);
            }
            char temp = q[front];
            front = (front + 1) % length;
            size--;
            return temp;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return length == size;
        }
    }
}