import java.util.*;

class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // T: O(n^2) | S: O(n^2). We would be storing each word and character in the
        // trie
        public void populateSuffixTrieFrom(String str) {

            for (int i = str.length() - 1; i >= 0; i--) {
                insertionHelper(i, str);
            }

        }

        public void insertionHelper(int i, String str) {
            TrieNode node = root;
            for (int j = i; i < str.length(); i++) {

                char letter = str.charAt(i);

                if (node.children.get(letter) == null) {
                    // map doesnt have letter.
                    node.children.put(letter, new TrieNode());
                }
                // Below is similar to node = node.next;
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }

        // T: O( length of str ) | S:O(1)
        public boolean contains(String str) {

            TrieNode node = root;

            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
