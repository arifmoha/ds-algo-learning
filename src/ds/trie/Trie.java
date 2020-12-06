package ds.trie;

import java.util.*;

class TrieNode {
    char c;
    HashMap<Character, TrieNode> children;
    //    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
//        children = new TrieNode[26];
    }

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean isEmpty() {
        return root.children.isEmpty();
    }

    public void insert(String word) {
        TrieNode curNode = root;
        for (char c : word.toCharArray()) {
            HashMap<Character, TrieNode> children = curNode.children;
//            if(children[c - 'a'] == null)
            if (children.containsKey(c)) {
                curNode = children.get(c);
            } else {
                curNode = new TrieNode(c);
                children.put(c, curNode);
            }
        }
        curNode.isEndOfWord = true;
    }

    public boolean find(String word) {
        TrieNode curNode = root;

        for (char c : word.toCharArray()) {
            if (!curNode.children.containsKey(c)) {
                return false;
            }
            curNode = curNode.children.get(c);
        }

        return curNode.isEndOfWord;
    }

    public HashMap<Character, TrieNode> getChildren(char c) {
        for (TrieNode child : root.children.values()) {
            if (child.c == c) return child.children;
        }

        return null;
    }

    public HashMap<Character, TrieNode> getChildren(String s) {
        TrieNode curNode = root;
        for (char c : s.toCharArray()) {
            if (!curNode.children.containsKey(c)) {
                return null;
            }
            curNode = curNode.children.get(c);
        }

        return curNode.children;
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        return longestWord(trie.root, "");
    }

    private String longestWord(TrieNode trieNode, String word) {
        String result = word;
        for (TrieNode child : trieNode.children.values()) {
            if (child.isEndOfWord) {
                char letter = child.c;
                String nextWord = longestWord(child, word + letter);
                if (nextWord.length() > result.length()) {
                    result = nextWord;
                } else if (nextWord.length() == result.length()) {
                    result = result.compareTo(nextWord) < 0 ? result : nextWord;
                }
            }
        }
        return result;
    }
}
