package racingcar.domain.racing.racer;

import java.util.Objects;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.accelerator.Accelerator;

public class Racer {
    private static final String ACCELERATOR_VALIDATION_ERROR = "Accelerator should not be null!";

    private final Accelerator accelerator;

    private Racer(Accelerator accelerator) {
        if (Objects.isNull(accelerator)) {
            throw new IllegalArgumentException(ACCELERATOR_VALIDATION_ERROR);
        }
        this.accelerator = accelerator;
    }

    public static Racer from(Accelerator accelerator) {
        return new Racer(accelerator);
    }

    public Car drive(Car car) {
        return car.accelerate(accelerator);
    }
}
