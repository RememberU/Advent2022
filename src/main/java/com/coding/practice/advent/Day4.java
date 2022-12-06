package com.coding.practice.advent;

import com.coding.practice.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day4 implements Day {

    private List<String> input = new ArrayList<>();
    private int result, partialOverlap =0;

    @Override
    public void readInput() {
        try {
            URL resource = getClass().getClassLoader().getResource("advent/day4.txt");
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
        System.out.format("Output1: %d Output2: %d", result, partialOverlap);
    }

    @Override
    public void solve() {
        result = getResult(input);

    }

    public int getResult(List<String> inputList) {
        List<List<Integer>> zones = new ArrayList<>();
        List<Integer> intervals = inputList.stream()
                .map(s -> s.split("[-,]"))
                .flatMap(Arrays::stream)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i=0; i<intervals.size(); i+=2) {
            zones.add(processInterval(intervals.get(i),intervals.get(i+1) ));
        }

        for (int i= 0; i<zones.size()-1; i+=2) {
            List<Integer> currentElement = zones.get(i);
            List<Integer> nextElement = zones.get(i + 1);
            if (currentElement.containsAll(nextElement) || nextElement.containsAll(currentElement)) result++;
            if (currentElement.stream().anyMatch(nextElement::contains)) partialOverlap++;

        }

        return result;
    }


    public List<Integer> processInterval(int lowerLimit, int upperLimit) {
        List<Integer> s = new ArrayList<>();
        for (int i= lowerLimit; i<=upperLimit; i++) {
            s.add(i);
        }
        return s;
    }
}
