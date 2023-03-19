package study;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Input input = new CliInput();
        Output output = new CliOutput();
        NumberGenerator numberGenerator = new NumberGenerator();
        BaseballGame baseballGame = new BaseballGame(input, output, numberGenerator);
        while (baseballGame.start());
    }

}
