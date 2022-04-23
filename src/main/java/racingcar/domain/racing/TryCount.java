package racingcar.domain.racing;

public class TryCount {
    private static final int MINIMUM_TRY = 1;
    private static final String INVALID_TRY_COUNT_ERROR = "시도 횟수는 최소 " + MINIMUM_TRY + " 이상이어야 합니다.";

    private final int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    public static TryCount from(int count) {
        return new TryCount(count);
    }

    public int get() {
        return count;
    }

    private void validate(int count) {
        if (count < MINIMUM_TRY) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_ERROR);
        }
    }
}
