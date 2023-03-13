import java.util.Random;

public class NumberGenerator {

    public final static int NUMBER_LENGTH = 3;

    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            sb.append(getRandomSingleDigit());
        }
        return sb.toString();
    }

    private String getRandomSingleDigit() {
        Random random = new Random();
        int randomSingleDigit = random.nextInt(9);
        return String.valueOf(randomSingleDigit);
    }

}
