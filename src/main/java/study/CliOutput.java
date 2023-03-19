package study;

import java.text.MessageFormat;

public class CliOutput implements Output {
    @Override
    public void show(String str) {
        System.out.println(str);
    }

    @Override
    public void showBallCount(BallCount ballCount) {
        System.out.println(MessageFormat.format("{0} 볼, {1} 스트라이크", ballCount.getBall(), ballCount.getStrike()));
    }
}
