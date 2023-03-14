import java.io.IOException;

public class BaseballGame {

    private final Input input;
    private final Output output;
    private final NumberGenerator numberGenerator;

    public BaseballGame(Input input, Output output, NumberGenerator numberGenerator) {
        this.input = input;
        this.output = output;
        this.numberGenerator = numberGenerator;
    }

    public boolean start() throws IOException {
        String answer = numberGenerator.generate();
        System.out.println(answer);
        while (!duringGame(answer));
        return askContinue();
    }

    private boolean duringGame(String answer) throws IOException {
        String userNumber = input.input("숫자를 입력해주세요 : ");
        BallCount ballCount = getBallCount(userNumber, answer);
        output.showBallCount(ballCount);
        return ballCount.isOut();
    }

    private BallCount getBallCount(String userNumber, String answer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < NumberGenerator.NUMBER_LENGTH; i++) {
            strike += Boolean.compare(checkStrike(userNumber, answer, i), false);
            ball += Boolean.compare(checkBall(userNumber, answer, i), false);
        }
        return new BallCount(strike, ball);
    }

    private boolean checkBall(String userNumber, String answer, int index) {
        boolean isStrike = userNumber.charAt(index) != answer.charAt(index);
        boolean isBall = answer.contains(String.valueOf(userNumber.charAt(index)));
        return isStrike && isBall;
    }

    private boolean checkStrike(String userNumber, String answer, int index) {
        return userNumber.charAt(index) == answer.charAt(index);
    }

    private boolean askContinue() throws IOException {
        output.show("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        String result = input.input("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return result.equals("1");
    }

}
