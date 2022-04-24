package racingcar.domain.racing.car;

import static racingcar.domain.constant.RacingGameConfiguration.CAR_NAME_MAX_LENGTH;
import static racingcar.domain.constant.RacingGameExceptions.INVALID_NAME_ERROR;
import static racingcar.domain.constant.RacingGameExceptions.NULL_NAME_ERROR;

import java.util.Objects;

public class Name {
    private final String value;

    private Name(String name) {
        validate(name);
        this.value = name;
    }

    static Name from(String name) {
        return new Name(name);
    }

    public String get() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    private void validate(String value) {
        validateNonNull(value);
        validateMaxLength(value);
    }

    private void validateMaxLength(String value) {
        if (value.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    private void validateNonNull(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(NULL_NAME_ERROR);
        }
    }
}
