package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputReader {

    public String readValue() {
        return Console.readLine()
                .trim();
    }

    public List<String> readValues() {
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .toList();
    }

}
