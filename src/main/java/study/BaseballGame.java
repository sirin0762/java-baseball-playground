package study;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {

    private final Input input;
    private final Output output;
    private final NumberGenerator numberGenerator;
    private final int GENERATED_NUMBER_LENGTH = 3;

    public BaseballGame(Input input, Output output, NumberGenerator numberGenerator) {
        this.input = input;
        this.output = output;
        this.numberGenerator = numberGenerator;
    }

    public boolean start() throws IOException {
        Balls comBalls = new Balls(numberGenerator.generate(GENERATED_NUMBER_LENGTH));
        while (!isDuringGame(comBalls));
        return askContinue();
    }

    public boolean isDuringGame(Balls comBalls) throws IOException {
        Balls userBalls = new Balls(getUserBalls());
        BallCount ballCount = comBalls.compare(userBalls);
        output.showBallCount(ballCount);
        return ballCount.isOut();
    }

    public List<Integer> getUserBalls() throws IOException {
        String userNumber = input.input("숫자를 입력해주세요 : ");
        return stringToIntegerList(userNumber);
    }
    
    private List<Integer> stringToIntegerList(String answer) {
        return Arrays.stream(answer.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean askContinue() throws IOException {
        output.show("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String result = input.input("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return result.equals("1");
    }

}
