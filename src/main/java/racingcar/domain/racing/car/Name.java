package racingcar.domain.racing.car;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String INVALID_NAME_ERROR = "자동차 이름은 5자 이하만 가능합니다.";

    private final String name;

    private Name(String name) {
        validate(name);
        this.name = name;
    }

    static Name from(String name) {
        return new Name(name);
    }

    private void validate(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_ERROR);
        }
    }
}
