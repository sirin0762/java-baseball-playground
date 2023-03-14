public class BallCount {

    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isOut() {
        return this.strike == NumberGenerator.NUMBER_LENGTH;
    }
}
