package racingcar.domain.racing.car.accelerator;

public class Power {
    private static final int MINIMUM_POWER = 0;
    private static final int MAXIMUM_POWER = 9;

    private static final String MIN_POWER_VALIDATION_ERROR =
            "파워값은 최소 " + MINIMUM_POWER + " 이상의 값만 허용합니다.";
    private static final String MAX_POWER_VALIDATION_ERROR =
            "파워값은 최대 " + MAXIMUM_POWER + " 이하의 값만 허용합니다.";

    private final int power;

    private Power(int power) {
        validate(power);
        this.power = power;
    }

    public static Power from(int power) {
        return new Power(power);
    }

    boolean isGreaterThanOrEqualTo(int input) {
        return power >= input;
    }

    private void validate(int power) {
        validateMin(power);
        validateMax(power);
    }

    private void validateMin(int power) {
        if (power < MINIMUM_POWER) {
            throw new IllegalArgumentException(MIN_POWER_VALIDATION_ERROR);
        }
    }

    private void validateMax(int power) {
        if (power > MAXIMUM_POWER) {
            throw new IllegalArgumentException(MAX_POWER_VALIDATION_ERROR);
        }
    }
}
