package com.HomeWork.Hillel;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<String, Integer> sortText = new HashMap<>();
    private static List<String> arrayList = new ArrayList<>();
    public static void main(String[] args) {
        readFile();
        findWordInText();
        System.out.println(sortText);
    }
    private static void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("input2.txt"))){
            String currentLine;
            while ((currentLine = br.readLine()) != null){
                arrayList.add(currentLine);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void findWordInText(){
        StringBuilder sb = new StringBuilder();
        for (String line : arrayList){
            sb.append(line);
        }
        String text = sb.toString().toLowerCase();
        String[] words = text.split("\\W+");
        for (int i=0; i<words.length; i++) {
            if (sortText.containsKey(words[i])) {
                sortText.put(words[i], sortText.get(words[i]) + 1);
            } else {
                sortText.put(words[i], 1);
            }
        }
    }

}

