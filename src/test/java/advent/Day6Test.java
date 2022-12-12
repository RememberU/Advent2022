package advent;

import com.coding.practice.advent.Day4;
import com.coding.practice.advent.Day6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("unit_test")
public class Day6Test {

    @ParameterizedTest
    @CsvSource({"mjqjpqmgbljsphdztnvjfqwrcgsmlb, 7",
            "bvwbjplbgvbhsrlpgdmjqwftvncz, 5",
            "nppdvjthqldpwncqszvftbrmjlhg, 6",
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg, 10",
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw, 11"
    })
    void testPartOne(String input, int result) {

        Day6 day = new Day6();
        Assertions.assertEquals(result, day.getResult(input));

    }

    @ParameterizedTest
    @CsvSource({"mjqjpqmgbljsphdztnvjfqwrcgsmlb, 19",
            "bvwbjplbgvbhsrlpgdmjqwftvncz, 23",
            "nppdvjthqldpwncqszvftbrmjlhg, 23",
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg, 29",
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw, 26"
    })
    void testPartTwo(String input, int result) {

        Day6 day = new Day6();
        Assertions.assertEquals(result, day.getResult2(input));

    }

}
