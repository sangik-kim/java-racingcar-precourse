package racingcar.domain.racing.car.accelerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Location;

public class AcceleratorTest {
    private static final int ORIGINAL_LOCATION = 0;

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Location initialLocation;

    @BeforeEach
    void setUp() {
        initialLocation = Location.from(ORIGINAL_LOCATION);
    }

    @Test
    void 자동차를_이동시킨다() {
        Accelerator accelerator = Accelerator.from(MOVING_FORWARD);

        assertThat(accelerator.moveCar(initialLocation)).isNotNull().isNotEqualTo(initialLocation);
    }

    @Test
    void 자동차를_이동시키지_않는다() {
        Accelerator accelerator = Accelerator.from(STOP);

        assertThat(accelerator.moveCar(initialLocation)).isNotNull().isEqualTo(initialLocation);
    }
}
