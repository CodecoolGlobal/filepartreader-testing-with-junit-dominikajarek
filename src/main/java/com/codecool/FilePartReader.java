package com.codecool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader(){
        filePath = "";
        fromLine = -1;
        toLine = -1;
    }

    public FilePartReader(String filePath, int fromLine, int toLine){
        setUp(filePath, fromLine, toLine);
    }

    public void setUp(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
    }

    public String read() throws IOException {
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    public String readLines() throws IOException {
        String[] content = read().split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < content.length; i++) {
            if (i + 1 >= fromLine && i + 1 <= toLine) {
                stringBuilder.append(content[i]).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
