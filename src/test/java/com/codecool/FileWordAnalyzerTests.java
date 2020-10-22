package com.codecool;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileWordAnalyzerTests {

    private FilePartReader filePartReader = new FilePartReader();
    private FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    private String textPath = "src/main/resources/text.txt";

    @Test
    public void testWordsAreOrderedAlphabetically() throws IOException {
        filePartReader.setUp(textPath, 3, 3);
        List<String> expected = new ArrayList<>(Arrays.asList("abcdef", "abcdfg", "abcjhf", "abcpokd"));
        List<String> actual = fileWordAnalyzer.getWordsOrderedAlphabetically();

        assertEquals(expected, actual);
    }

    @Test
    public void testWordsContainSubstring() throws IOException {
        filePartReader.setUp(textPath, 1, 3);
        String substring = "abc";
        List<String> wordsContainSubstring = new ArrayList<>(Arrays.asList("abcdef", "abcdfg", "abcjhf", "abcpokd"));
        List<String> actual = fileWordAnalyzer.getWordsContainingSubstring(substring);
        assertEquals(wordsContainSubstring, actual);
    }

    @Test
    public void testIfWordsPalindromes() throws IOException {
        List<String> palindromes = new ArrayList<>(Arrays.asList("anna", "kayak", "madam", "level", "refer"));
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setUp(textPath, 1, 1);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(palindromes, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}