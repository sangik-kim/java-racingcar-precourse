package racingcar.domain.racing.racer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.accelerator.generator.AcceleratorGenerator;
import racingcar.domain.racing.car.accelerator.generator.ManualAcceleratorGenerator;

public class RacerTest {
    private static final int ORIGINAL_LOCATION = 0;
    private static final int MOVING_FORWARD = 4;

    private Car car;
    private Racer racer;

    @BeforeEach
    void setUp() {
        AcceleratorGenerator acceleratorGenerator = ManualAcceleratorGenerator.from(MOVING_FORWARD);
        racer = Racer.from(acceleratorGenerator);

        car = Car.of("NZCar", ORIGINAL_LOCATION);
    }

    @Test
    @DisplayName("운전하면 새로운 자동차 상태를 받는다")
    void 운전하면_새로운_자동차_상태를_받는다() {
        assertThat(racer.drive(car)).isNotNull();
    }
}
