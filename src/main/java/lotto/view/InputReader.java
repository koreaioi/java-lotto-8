package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputReader {

    private static final String STRING_DELIMITER = ",";

    public String readValue() {
        return Console.readLine()
                .trim();
    }

    public List<String> readValues() {
        return Arrays.stream(Console.readLine().split(STRING_DELIMITER))
                .map(String::trim)
                .toList();
    }

}
