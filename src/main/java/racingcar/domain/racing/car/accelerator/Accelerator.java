package racingcar.domain.racing.car.accelerator;

import java.util.Objects;
import racingcar.domain.racing.car.Location;

public class Accelerator {
    private static final String POWER_NULL_ERROR = "파워는 null이 될 수 없습니다.";
    private static final String LOCATION_NULL_ERROR = "위치값은 null이 될 수 없습니다.";

    private static final int MINIMUM_GO_VALUE = 4;
    private static final int MOVED_DISTANCE = 1;

    private final Power power;

    private Accelerator(Power power) {
        validate(power);
        this.power = power;
    }

    private Accelerator(int power) {
        this.power = Power.from(power);
    }

    public static Accelerator from(Power power) {
        return new Accelerator(power);
    }

    public static Accelerator from(int power) {
        return new Accelerator(power);
    }

    public Location moveCar(Location currentLocation) {
        if (Objects.isNull(currentLocation)) {
            throw new IllegalArgumentException(LOCATION_NULL_ERROR);
        }
        return isMovingForward() ? currentLocation.add(MOVED_DISTANCE) : currentLocation;
    }

    private boolean isMovingForward() {
        return power.isGreaterThanOrEqualTo(MINIMUM_GO_VALUE);
    }

    private void validate(Power power) {
        if (Objects.isNull(power)) {
            throw new IllegalArgumentException(POWER_NULL_ERROR);
        }
    }
}
