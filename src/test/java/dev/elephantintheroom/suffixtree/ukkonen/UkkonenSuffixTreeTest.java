package dev.elephantintheroom.suffixtree.ukkonen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UkkonenSuffixTreeTest {

    @Test
    void containsInSingleCharacterString() {
        var singleCharacter = new UkkonenSuffixTree("a");
        assertTrue(singleCharacter.contains("a"));
        assertFalse(singleCharacter.contains("b"));
    }

    @Test
    void containsInSimpleStringWithNoRepetition() {
        var simpleString = new UkkonenSuffixTree("pear");
        assertTrue(simpleString.contains("pear"));
        assertTrue(simpleString.contains("p"));
        assertTrue(simpleString.contains("r"));
        assertTrue(simpleString.contains("pe"));
        assertTrue(simpleString.contains("ea"));
        assertTrue(simpleString.contains("ar"));
        assertFalse(simpleString.contains("b"));
        assertFalse(simpleString.contains("bear"));
    }
}
