package advent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.coding.practice.advent.Day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit_test")
public class Day3Test {



    @Test
    void testPartOne() {

        List<String> input = new ArrayList<>(
                Arrays.asList("vJrwpWtwJgWrhcsFMMfFFhFp",
                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                        "PmmdzqPrVvPwwTWBwg",
                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                        "ttgJtRGJQctTZtZT",
                        "CrZsJsPPZsGzwwsLwLmpwMDw"));
        Day3 day = new Day3();
        int result = day.getResult(input);
        Assertions.assertEquals(157, result);
    }

    @Test
    void testPartTwo() {

        List<String> input = new ArrayList<>(
                Arrays.asList("vJrwpWtwJgWrhcsFMMfFFhFp",
                        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                        "PmmdzqPrVvPwwTWBwg",
                        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                        "ttgJtRGJQctTZtZT",
                        "CrZsJsPPZsGzwwsLwLmpwMDw"));
        Day3 day = new Day3();
        int result = day.getResult2(input);
        Assertions.assertEquals(70, result);
    }
}
