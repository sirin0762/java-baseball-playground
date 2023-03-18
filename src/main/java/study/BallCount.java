package study;

public class BallCount {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void count(BallStatus status) {
        if (isStrike(status)) strike++;
        if (isBall(status)) ball++;
    }

    private boolean isStrike(BallStatus status) {
        return status == BallStatus.STRIKE;
    }

    private boolean isBall(BallStatus status) {
        return status == BallStatus.BALL;
    }

    public boolean isOut() {
        return this.strike == 3;
    }
}
