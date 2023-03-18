package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {

    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> generate(int length) {
        inputNumbers(length);
        return numbers;
    }

    public void inputNumbers(int length) {
        while (!(numbers.size() == length)) {
            inputNumber(generateOneNumber());
        }
    }

    public void inputNumber(int number) {
        if (haveDuplicatedNumber(number)) return;
        numbers.add(number);
    }

    public boolean haveDuplicatedNumber(int number) {
        return numbers.contains(number);
    }

    public int generateOneNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

}
