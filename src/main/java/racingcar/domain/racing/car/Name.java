package racingcar.domain.racing.car;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String NULL_NAME_ERROR = "자동차 이름은 null이 될 수 없습니다.";
    private static final String INVALID_NAME_ERROR = "자동차 이름은 " + MAX_LENGTH + "자 이하만 가능합니다.";

    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    static Name from(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return name;
    }

    private void validate(String value) {
        validateNonNull(value);
        validateMaxLength(value);
    }

    private void validateMaxLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }

    private void validateNonNull(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(NULL_NAME_ERROR);
        }
    }
}
