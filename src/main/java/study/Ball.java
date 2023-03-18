package study;

import java.util.Objects;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus compare(Ball other) {
        if (this.equals(other)) return BallStatus.STRIKE;
        if (this.isBall(other)) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball other) {
        return this.number == other.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

}
