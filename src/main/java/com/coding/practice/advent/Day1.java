package com.coding.practice.advent;

import com.coding.practice.Day;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;


public class Day1 implements Day {

    private int result=0;
    private Map<Integer, Integer> elfs = new HashMap<>();

    @Override
    public void readInput() {
        try {
            URL resource = getClass().getClassLoader().getResource("advent/day1.txt");
            File myObj = new File(resource.toURI());
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            int sum = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.isEmpty()) {
                    elfs.put(i, sum);
                    i++;
                    sum = 0;
                } else {
                    sum+= Integer.parseInt(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void printOutput()  {
        System.out.format("Output: %d", result);
    }

    @Override
    public void solve() {
        List<Integer>sortedMap =
                elfs.values().stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        for (int i=0; i<3; i++)  {
            result+= sortedMap.get(i);
        }

    }
}
