class PrefixTree {
     private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    // Time: O(L), Space: O(L) for new nodes
    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isWord = true;
    }

    // Time: O(L), Auxiliary Space: O(1)
    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    // Time: O(P), Auxiliary Space: O(1)
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // Common traversal logic
    private TrieNode findNode(String str) {
        TrieNode current = root;

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}
