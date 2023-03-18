package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    private Balls comBalls;

    @BeforeEach
    void setup() {
        comBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("1 strike, 1 ball")
    void oneStrikeAndOneBall() {
        Balls userBalls = new Balls(Arrays.asList(1, 3, 4));
        BallCount ballCount = comBalls.compare(userBalls);
        assertThat(ballCount.getStrike()).isEqualTo(1);
        assertThat(ballCount.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("out")
    void out() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        BallCount ballCount = comBalls.compare(userBalls);
        assertThat(ballCount.isOut()).isTrue();
    }


    @Test
    @DisplayName("하나의 볼이 위치와 숫자가 맞으면 1 Strike 이다.")
    void oneStrike() {
        Ball ball = new Ball(1, 1);
        assertThat(comBalls.compare(ball)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("하나의 볼이 숫자만 맞으면 1 ball 이다.")
    void oneBall() {
        Ball ball = new Ball(2, 1);
        assertThat(comBalls.compare(ball)).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("하나의 볼이 위치와 숫자가 모두 다르면 낫싱이다.")
    void oneNothing() {
        Ball ball = new Ball(3, 9);
        assertThat(comBalls.compare(ball)).isEqualTo(BallStatus.NOTHING);
    }

}
