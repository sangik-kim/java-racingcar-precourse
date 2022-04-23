package racingcar.domain.racing;

import racingcar.domain.racing.car.Cars;

public class Racing {
    private final Cars participants;

    private Racing(String carNames) {
        participants = Cars.from(carNames);
    }

    public static Racing from(String carNames) {
        return new Racing(carNames);
    }

    public Cars getParticipants() {
        return participants;
    }
}
