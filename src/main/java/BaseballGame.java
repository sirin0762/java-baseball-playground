import java.io.IOException;

public class BaseballGame {

    private Input input;
    private Output output;
    private NumberGenerator numberGenerator;

    public BaseballGame(Input input, Output output, NumberGenerator numberGenerator) {
        this.input = input;
        this.output = output;
        this.numberGenerator = numberGenerator;
    }

    public boolean start() throws IOException {
        String answer = numberGenerator.generate();

        while (true) {
            String userNumber = input.input("숫자를 입력해주세요 : ");
            Baseball baseball = getBaseball(userNumber, answer);
            if (baseball.isOut()) {
                return askContinue();
            } else {
                output.showStrikesAndBalls(baseball);
            }
        }
    }

    private Baseball getBaseball(String userNumber, String answer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NumberGenerator.NUMBER_LENGTH; i++) {
            if (userNumber.charAt(i) == answer.charAt(i)) {
                strike++;
            } else {
                ball++;
            }
        }
        return new Baseball(strike, ball);
    }

    private boolean askContinue() throws IOException {
        output.show("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String result = input.input("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return result.equals("1");
    }

}
