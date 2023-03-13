import java.text.MessageFormat;

public class CliOutput implements Output {
    @Override
    public void show(String str) {
        System.out.println(str);
    }

    @Override
    public void showStrikesAndBalls(Baseball baseball) {
        System.out.println(MessageFormat.format("{0} 볼, {1} 스트라이크", baseball.getBall(), baseball.getStrike()));
    }
}
