package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    private Ball comBall;

    @BeforeEach
    void setUp() {
        comBall = new Ball(1, 1);
    }

    @Test
    @DisplayName("컴퓨터 Ball과 위치, 숫자가 같은 사용자의 볼을 비교하면 스트라이크이다.")
    void strikeTest() {
        Ball userBall = new Ball(1, 1);
        assertThat(comBall.compare(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("컴퓨터 Ball과 위치는 다르고 숫자만 같은 사용자의 볼을 비교하면 볼이다.")
    void ballTest() {
        Ball userBall = new Ball(2, 1);
        assertThat(comBall.compare(userBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터 Ball과 위치, 숫자가 모두 다른 사용자의 볼을 비교하면 낫싱이다.")
    void nothingTest() {
        Ball userBall = new Ball(3, 9);
        assertThat(comBall.compare(userBall)).isEqualTo(BallStatus.NOTHING);
    }

}
