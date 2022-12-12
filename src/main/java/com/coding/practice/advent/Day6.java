package com.coding.practice.advent;

import com.coding.practice.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day6 implements Day {
    private static int SIZE_MARKER = 4;
    private static int SIZE_MARKER_2 = 14;
    private String input;
    private int result;
    @Override
    public void readInput() {
        try {
            URL resource = getClass().getClassLoader().getResource("advent/day6.txt");
            File myObj = new File(resource.toURI());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                input = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void printOutput() {
        System.out.format("Output1: %d , Output2: %d ", result, getResult2(input));
    }

    @Override
    public void solve() {
        result = getResult(input);
    }

    public int getResult(String inputString) {

        LinkedList<Character> fifo = new LinkedList<>();

        for (int i=0; i<inputString.length(); i++) {
            fifo.add (inputString.charAt(i));
            if (fifo.size()==SIZE_MARKER) {
                if (isMarker(fifo)) {
                    return i+1;
                } else {
                    fifo.removeFirst();
                }
            }
        }
        return 0;
    }

    public int getResult2(String inputString) {

        LinkedList<Character> fifo = new LinkedList<>();

        for (int i=0; i<inputString.length(); i++) {
            fifo.add (inputString.charAt(i));
            if (fifo.size()==SIZE_MARKER_2) {
                if (isMarker(fifo)) {
                    return i+1;
                } else {
                    fifo.removeFirst();
                }
            }
        }
        return 0;
    }

    public boolean isMarker(LinkedList<Character> fifo) {

        return fifo.size() == fifo.stream().distinct().collect(Collectors.toList()).size();
    }

}
