import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaseballGameTest {

    @Mock Input input;

    @Mock Output output;

    @Mock NumberGenerator generator;

    BaseballGame baseballGame = new BaseballGame(input, output, generator);

    @Test
    @DisplayName("스트라이크와 볼의 갯수를 샌다.")
    void getBallCount() {
        when(generator.generate()).thenReturn("123");
        String answer = "123";
        String userNumber = generator.generate();
        BallCount ballCount = baseballGame.getBallCount(answer, userNumber);
        assertThat(ballCount.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("아웃인지 확인한다")
    void isOut() {
        when(generator.generate()).thenReturn("123");
        String answer = "123";
        String wrongAnswer = "456";
        String userNumber = generator.generate();
        BallCount answerBallCount = baseballGame.getBallCount(answer, userNumber);
        BallCount wrongBallCount = baseballGame.getBallCount(wrongAnswer, userNumber);
        assertThat(baseballGame.isOut(answerBallCount)).isTrue();
        assertThat(baseballGame.isOut(wrongBallCount)).isFalse();
    }
}