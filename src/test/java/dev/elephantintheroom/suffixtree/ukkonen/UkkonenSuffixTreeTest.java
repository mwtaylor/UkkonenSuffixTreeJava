package dev.elephantintheroom.suffixtree.ukkonen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UkkonenSuffixTreeTest {

    @Test
    void contains() {
        var singleCharacter = new UkkonenSuffixTree("a");
        assertTrue(singleCharacter.contains("a"));
        assertFalse(singleCharacter.contains("b"));
    }
}
