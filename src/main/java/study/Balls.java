package study;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        this.balls = matchIntegerToBalls(numbers);
    }

    public BallStatus compare(Ball other) {
        return balls.stream()
                .map(ball -> ball.compare(other))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private List<Ball> matchIntegerToBalls(List<Integer> balls) {
        List<Ball> list = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            list.add(new Ball(i + 1, balls.get(i)));
        }
        return list;
    }

    public BallCount compare(Balls userBalls) {
        BallCount ballCount = new BallCount();
        for (int i = 0; i < this.balls.size(); i++) {
            ballCount.count(this.compare(userBalls.balls.get(i)));
        }
        return ballCount;
    }

}
