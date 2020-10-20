package com.codecool;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String text = filePartReader.readLines();
        String[] words = filePartReader.readLines().split("[^a-zA-Z0-9]+");
        Arrays.sort(words);
        return Arrays.asList(words);
    }

    public List<String> getWordsContainingSubstring(String substring) throws IOException {
        String[] words = filePartReader.readLines().split("[^a-zA-Z0-9]+");
        List<String> wordsWithSubstring = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().contains(substring.toLowerCase())) {
                wordsWithSubstring.add(word);
            }
        }
        return wordsWithSubstring;
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        String[] words = filePartReader.readLines().split("[^a-zA-Z0-9]+");
        List<String> palindromeWords = new ArrayList<>();
        for (String word : words) {
            if (word.toLowerCase().equals(new StringBuilder(word.toLowerCase()).reverse().toString())) {
                palindromeWords.add(word);
            }
        }
        return palindromeWords;
    }

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setUp("src/main/resources/text.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("abc"));
        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
    }
}
