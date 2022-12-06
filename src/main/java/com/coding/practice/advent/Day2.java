package com.coding.practice.advent;

import com.coding.practice.Day;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day2 implements Day {

    private List<String> input = new ArrayList<>();
    private int result, result2 =0;

    @Override
    public void readInput() {
        try {
            URL resource = getClass().getClassLoader().getResource("advent/day2.txt");
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
        System.out.format("Output1: %d Output2: %d", result, result2);
    }

    @Override
    public void solve() {
        Map<String, Integer> draw =   ImmutableMap.<String, Integer>builder()
                .put("A X", 1)
                .put("B Y", 2)
                .put("C Z", 3)
                .build();
        Map<String, Integer> win =   ImmutableMap.<String, Integer>builder()
                .put("A Y", 2)
                .put("B Z", 3)
                .put("C X", 1)
                .build();
        Map<String, Integer> lose =   ImmutableMap.<String, Integer>builder()
                .put("A Z", 3)
                .put("B X", 1)
                .put("C Y", 2)
                .build();

        for(String round:input){
            if (win.containsKey(round)) result+=win.get(round)+6;
            if (draw.containsKey(round)) result+=draw.get(round)+3;
            if (lose.containsKey(round)) result+=lose.get(round);
        }
        // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
        for(String round:input){
            if (round.charAt(2) == 'X') result2 +=lose.get(getKey(lose, round));
            if (round.charAt(2) == 'Y') result2 +=draw.get(getKey(draw, round))+3;
            if (round.charAt(2) == 'Z') result2 +=win.get(getKey(win, round))+6;
        }
    }

    private String getKey(Map<String, Integer> lose, String round) {
        String test= lose.keySet().stream().filter(key -> key.startsWith(String.valueOf(round.charAt(0)))).findFirst().get();
        return test;
    }

}
