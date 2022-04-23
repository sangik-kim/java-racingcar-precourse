package racingcar.domain.racing.racer;

import java.util.Objects;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.accelerator.generator.AcceleratorGenerator;

public class Racer {
    private static final String ACCELERATOR_GENERATOR_NULL_ERROR = "AcceleratorGenerator는 null 값을 가질 수 없습니다.";

    private final AcceleratorGenerator acceleratorGenerator;

    private Racer(AcceleratorGenerator acceleratorGenerator) {
        validateNonNull(acceleratorGenerator);
        this.acceleratorGenerator = acceleratorGenerator;
    }

    public static Racer from(AcceleratorGenerator acceleratorGenerator) {
        return new Racer(acceleratorGenerator);
    }

    public Car drive(Car car) {
        return car.accelerate(acceleratorGenerator.generate());
    }

    private void validateNonNull(AcceleratorGenerator acceleratorGenerator) {
        if (Objects.isNull(acceleratorGenerator)) {
            throw new IllegalArgumentException(ACCELERATOR_GENERATOR_NULL_ERROR);
        }
    }
}
