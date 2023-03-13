import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberGeneratorTest {

    NumberGenerator generator = new NumberGenerator();

    @Test
    void generate() {
        String randomNumber = generator.generate();
        assertThat(randomNumber.length()).isEqualTo(3);
    }
}