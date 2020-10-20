package com.codecool;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {

    private FilePartReader filePartReader = new FilePartReader();
    private String textPath = "src/main/resources/text.txt";

    @Test
    public void testReturnFirstLine() throws IOException {
        String expected = "anna kayak madam level refer\n";
        filePartReader.setUp(textPath, 1, 1);
        String actual = filePartReader.readLines();
        assertEquals(expected, actual);
    }

    @Test
    public void returnStringIfFound() throws IOException {
        String expected = "cat dog apple banana juice cake\n";
        filePartReader.setUp(textPath, 2, 2);
        String actual = filePartReader.readLines();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfThrowsExceptionWhenCannotFindFile() {
        filePartReader.setUp("random/text/path", 1, 3);
        assertThrows(IOException.class, () -> filePartReader.read());
    }

    @Test
    public void testIfToLineIsLowerThanFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setUp(textPath, 3, 1));
    }

    @Test
    public void testIfFromLineIsLowerThan1() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setUp(textPath, 0, 1));
    }
}