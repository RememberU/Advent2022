package com.coding.practice.advent;

import com.coding.practice.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Day3 implements Day {

    private List<String> input = new ArrayList<>();
    private int result =0;

    @Override
    public void readInput() {
        try {
            URL resource = getClass().getClassLoader().getResource("advent/day3.txt");
            File myObj = new File(resource.toURI());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                input.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void printOutput() {
        System.out.format("Output1: %d / Output2: %d", result, getResult2(input));
    }

    @Override
    public void solve() {
        result = getResult(input);
    }

    public int getResult(List<String> inputList) {
        int total = 0;
        for (String element: inputList) {
            int length = element.length()/2;
            String duplicate = getDuplicate(element.substring(0, length), element.substring(length));
            total += getPriority(duplicate.charAt(0));
        }
        return total;
   }

    public int getResult2(List<String> inputList) {
        int total = 0;
        for (int i=0; i<inputList.size()-2; i+=3) {
            String duplicate = getDuplicate(getDuplicate(inputList.get(i), inputList.get(i+1)), inputList.get(i+2));
            total += getPriority(duplicate.charAt(0));
        }
        return total;
    }

    public String getDuplicate(String rucksack1, String rucksack2) {
        Set<Character> arrSet1 = new HashSet(convertStringToCharList(rucksack1));
        Set<Character> arrSet2 = new HashSet(convertStringToCharList(rucksack2));
        arrSet1.retainAll(arrSet2);
        return arrSet1.stream().map(e -> String.valueOf(e))
                .reduce((acc, e) -> acc  + e)
                .get();
    }

    public int getPriority(char letter) {
        if (Character.isUpperCase(letter)) {
            return (letter - 38);
        }
        return letter - 96;
    }

    public static List<Character> convertStringToCharList(String str) {

        return str.chars() .mapToObj(e -> (char)e).collect(Collectors.toList());

    }
}
