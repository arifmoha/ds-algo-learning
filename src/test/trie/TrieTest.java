package test.trie;

import ds.trie.Trie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrieTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testInsertAndFind(){
        Trie trie = new Trie();
        assertTrue(trie.isEmpty());

        trie.insert("ana");
        assertFalse(trie.isEmpty());
        assertTrue(trie.find("ana"));

        assertFalse(trie.find("and"));
        trie.insert("and");
        assertTrue(trie.find("and"));

        assertFalse(trie.find("an"));
        trie.insert("an");
        assertTrue(trie.find("an"));

        Set<Character> set = new HashSet<>();
        set.add('a');set.add('d');
        assertEquals(set, trie.getChildren("an").keySet());
    }

    @Test
    void testLongestWord(){
        Trie trie = new Trie();

        assertEquals("apple",
                trie.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));

        assertEquals("world",
                trie.longestWord(new String[]{"w","wo","wor","worl", "world"}));

        assertEquals("latte",
                trie.longestWord(new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"}));

        assertEquals("yodn",
                trie.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));

    }
}
