package racingcar.domain.racing.car.accelerator;

import racingcar.domain.racing.car.Location;

public class Accelerator {
    private static final int MINIMUM_GO_VALUE = 4;
    private static final int MOVED_DISTANCE = 1;

    private final Power power;

    private Accelerator(int power) {
        this.power = Power.from(power);
    }

    public static Accelerator from(int power) {
        return new Accelerator(power);
    }

    public Location moveCar(Location currentLocation) {
        return isMovingForward() ? currentLocation.add(MOVED_DISTANCE) : currentLocation;
    }

    private boolean isMovingForward() {
        return power.isGreaterThanOrEqualTo(MINIMUM_GO_VALUE);
    }
}
