package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberGeneratorTest {

    private final int GENERATED_NUMBER_LENGTH = 3;

    @Test
    @DisplayName("컴퓨터는 한자리 숫자를 생성한다")
    void generateOneNumber() {
        NumberGenerator generator = new NumberGenerator();
        int number = generator.generateOneNumber();
        assertThat(number).isInstanceOfAny(Integer.class);
        assertThat(number).isLessThan(10).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("컴퓨터는 세자리의 렌덤한 수를 생성한다.")
    void generate() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> generatedNumber = generator.generate(GENERATED_NUMBER_LENGTH);
        assertThat(generatedNumber.size()).isEqualTo(GENERATED_NUMBER_LENGTH);
    }

}
