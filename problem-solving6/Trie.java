public class Trie {
    // Driver
    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        // String keys[] = {"the", "a", "there", "answer", "any",
        //                  "by", "bye", "their"};
        String keys[] = {"the", "a", "there"};
       
        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();
        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        if (search("the") == true) {
            System.out.println("the --- " + output[1]);
        } else {
            System.out.println("the --- " + output[0]);
        }
        if (search("these") == true) {
            System.out.println("these --- " + output[1]);
        } else {
            System.out.println("these --- " + output[0]);
        }
        if (search("there") == true) {
            System.out.println("there --- " + output[1]);
        } else {
            System.out.println("there --- " + output[0]);
        }
    }

    // Size of integers.
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfArray is true if the node represents
        // end of a array
        boolean isEndOfArray;

        TrieNode() {
            isEndOfArray = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    };

    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        // mark last node as leaf
        pCrawl.isEndOfArray = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null) {
                return false;
            }

            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfArray);
    }
}
