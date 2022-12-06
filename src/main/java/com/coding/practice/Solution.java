package com.coding.practice;

import com.coding.practice.advent.*;

public class Solution {

    static long TIME_START, TIME_END;
    public static void main(String[] args) {

        Day day = new Day5();//1, 2, 3, 4...
        day.readInput();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        day.solve();
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.err.println("\nMemory increased: " + (usedMemoryAfter - usedMemoryBefore));
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
        day.printOutput();


    }

}
