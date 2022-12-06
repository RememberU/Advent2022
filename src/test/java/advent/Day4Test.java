package advent;

import com.coding.practice.advent.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag("unit_test")
public class Day4Test {

    @Test
    void testPartOne() {

        List<String> input = new ArrayList<>(
                Arrays.asList("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8"));
        Day4 day = new Day4();
        int result = day.getResult(input);
        Assertions.assertEquals(2, result);
    }

}
