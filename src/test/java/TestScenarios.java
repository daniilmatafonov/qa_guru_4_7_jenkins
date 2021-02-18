import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestScenarios {
    @Test
    @Tag("positive")
    void successTest() {
        assertEquals(true, true);
    }

    @Test
    @Tag("negative")
    void negativeArithmeticExceptionTest() throws ArithmeticException {
        Throwable thrown = assertThrows(ArithmeticException.class, () -> {
            int a = 5, b, result;
            b = 0;
            result = a / b;
            System.out.println(result);
        });
        assertNotNull(thrown.getMessage());

    }

    @Test
    @Tag("positive")
    void successWithHamcrestTest() {
        assertThat(true, Matchers.equalTo(Boolean.TRUE));
    }

    @Test
    @Tag("positive")
    @DisplayName("Some positive test")
    void successWithHamcrestAndStepsTest() {
        step("Assert that true is true", () ->
                assertThat(true, Matchers.equalTo(Boolean.TRUE)));
    }
}
