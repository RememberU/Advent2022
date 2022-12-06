package com.coding.practice.advent;

import com.coding.practice.Day;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 implements Day {

    private final static Pattern p = Pattern.compile("\\d+");

    List<String> inputMoves = new ArrayList<>();
    String result = "";
    String result2 = "";

    @Override
    public void readInput() {
        try {
            URL resource = getClass().getClassLoader().getResource("advent/day5.txt");
            File myObj = new File(resource.toURI());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputMoves.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void printOutput() {
        System.out.format("Output1: %s Output2: %s ", result, result2);
    }

    @Override
    public void solve() {
       result = solve1();
       result2 = solve2();
    }

    public String solve1() {
        Map<Integer,Stack<String>> input = getInputDiagram(new HashMap<>());
        for (String move:inputMoves) {
            List<Integer> moves = parseTheMove(move);
            for (int i= 0; i< moves.get(0); i++) {
                String item = input.get(moves.get(1)).pop();
                input.get(moves.get(2)).push(item);
            }
        }
        return getResult(input, result);
    }

    public String solve2() {
        Map<Integer,Stack<String>> input = getInputDiagram(new HashMap<>());
        for (String move:inputMoves) {
            List<Integer> moves = parseTheMove(move);
            List<String> keepOrder = new ArrayList<>();
            for (int i= 0; i< moves.get(0); i++) {
                String item = input.get(moves.get(1)).pop();
                keepOrder.add(item);
            }
            for (int i= moves.get(0)-1; i>=0 ; i--) {
                input.get(moves.get(2)).push(keepOrder.get(i));
            }
        }
        return getResult(input, result2);
    }

    private String getResult(Map<Integer, Stack<String>> input, String result) {
        for (int i= 1; i< 10; i++) {
            if (input.containsKey(i) && !input.get(i).isEmpty()) {
                result +=  input.get(i).peek();
            }
        }
        return result;
    }

    private List<Integer> parseTheMove(String s) {
        List<Integer> matches = new ArrayList<>();
        Matcher matcher = p.matcher(s);
        while (matcher.find()) {
            matches.add(Integer.parseInt(matcher.group()));
        }
        return  matches;
    }


    private Map<Integer, Stack<String>> getInputDiagram(Map<Integer, Stack<String>> input) {
        Stack<String> column1 = new Stack<>();
        Collections.addAll(column1, "P", "F", "M", "Q", "W", "G", "R", "T");
        input.put(1, column1);
        Stack<String> column2 = new Stack<>();
        Collections.addAll(column2, "H", "F", "R");
        input.put(2, column2);
        Stack<String> column3 = new Stack<>();
        Collections.addAll(column3, "P", "Z", "R", "V", "G", "H", "S", "D");
        input.put(3, column3);
        Stack<String> column4 = new Stack<>();
        Collections.addAll(column4, "Q", "H", "P", "B", "F", "W", "G");
        input.put(4, column4);
        Stack<String> column5 = new Stack<>();
        Collections.addAll(column5, "P", "S", "M", "J", "H");
        input.put(5, column5);
        Stack<String> column6 = new Stack<>();
        Collections.addAll(column6, "M", "Z", "T", "H", "S", "R", "P", "L");
        input.put(6, column6);
        Stack<String> column7 = new Stack<>();
        Collections.addAll(column7, "P", "T", "H", "N", "M", "L");
        input.put(7, column7);
        Stack<String> column8 = new Stack<>();
        Collections.addAll(column8, "F", "D", "Q", "R");
        input.put(8, column8);
        Stack<String> column9 = new Stack<>();
        Collections.addAll(column9, "D", "S", "C", "N", "L", "P", "H");
        input.put(9, column9);
        return input;
    }
}
