import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberGeneratorTest {

    NumberGenerator generator = new NumberGenerator();

    @Test
    @DisplayName("3자리의 렌덤한 숫자를 생성한다.")
    void generate() {
        String randomNumber = generator.generate();
        assertThat(randomNumber.length()).isEqualTo(3);
    }
}