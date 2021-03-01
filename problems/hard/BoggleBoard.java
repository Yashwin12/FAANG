import java.util.*;

// T: W*L + N*M*8^L | S: W*L + N*M
// W = Number of words, L = length of the longest word
// N = Number of rows, M = Number of columns.
class Program {

    // Up, down, left, right, up-left, up-right, down-left, down-right
    private static int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
    private static int totalRow;
    private static int totalCol;

    public static List<String> boggleBoard(char[][] board, String[] words) {

        SuffixTrie suffixTrie = new SuffixTrie();

        for (String word : words) {
            suffixTrie.buildTrieDS(word);
        }

        totalRow = board.length;
        totalCol = board[0].length;

        // Set is used so that we do not store the same "final" word more than once.
        Set<String> set = new HashSet<>();

        int[][] visited = new int[totalRow][totalCol];

        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalCol; col++) {
                dfsHelper(board, visited, row, col, set, suffixTrie.root);
            }
        }

        return new ArrayList<>(set);
    }

    private static void dfsHelper(char[][] board, int[][] visited, int row, int col, Set<String> set, Node current) {

        char currentChar = board[row][col];

        if ( !current.children.containsKey(currentChar)) {
            return;
        }
        visited[row][col] = 1;
        current = current.children.get(currentChar);

        if ( current.children.containsKey('*')) {
            set.add(current.word);
        }

        for (int[] direction : DIRECTIONS) {
            int dr = row + direction[0];
            int dc = col + direction[1];

            if ( isSafe(board, visited, dr, dc)) {
                dfsHelper(board, visited, dr, dc, set, current);
            }
        }

        visited[row][col] = 0;
    }

    private static boolean isSafe(char[][] board, int[][] visited, int row, int col) {
        if ( row >= 0 && row < totalRow && col >= 0 && col < totalCol && visited[row][col] == 0)
            return true;

        return false;
    }

    public static class Node {
        private Map<Character, Node> children = new HashMap<>();
        private String word = ""; // This is to store word at the end of buildTrieDS method!
    }

    public static class SuffixTrie {
        private Node root;
        private char endChar = '*';

        SuffixTrie() {
            root = new Node();
        }

        // yash, yass, sal
        public void buildTrieDS(String word) {
            Node current = this.root;
            for (char ch : word.toCharArray()) {

                if ( !current.children.containsKey(ch)) {
                    current.children.put(ch, new Node());
                }
                // Similar to current = current.next in BTs.
                current = current.children.get(ch);
            }

            current.children.put(endChar, null);
            current.word = word;
        }

    }
}
