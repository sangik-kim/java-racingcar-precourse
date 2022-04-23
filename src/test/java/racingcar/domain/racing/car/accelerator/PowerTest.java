package racingcar.domain.racing.car.accelerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PowerTest {
    @Nested
    class 유효성_검사 {
        @Test
        void 파워는_0과_9사이의_값을_가진다() {
            assertThat(Power.from(0)).isNotNull();
            assertThat(Power.from(9)).isNotNull();
        }

        @Test
        void 그_이외의_값은_예외를_발생시킨다() {
            assertThatThrownBy(() -> Power.from(-1)).isInstanceOf(
                    IllegalArgumentException.class);
            assertThatThrownBy(() -> Power.from(10)).isInstanceOf(
                    IllegalArgumentException.class);
        }
    }
}
