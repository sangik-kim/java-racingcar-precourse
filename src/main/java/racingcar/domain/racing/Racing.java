package racingcar.domain.racing;

import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.RandomAcceleratorGenerator;
import racingcar.domain.racing.racer.CarRacers;

public class Racing {
    private final Cars participants;

    private Racing(String carNames) {
        participants = Cars.from(carNames);
    }

    public static Racing from(String carNames) {
        return new Racing(carNames);
    }

    public void start(int tryCount) {
        CarRacers carRacers = CarRacers.from(participants, RandomAcceleratorGenerator.create());
        for (int i = 0; i < TryCount.from(tryCount).get(); i++) {
            carRacers = carRacers.race();
        }
    }

    public Cars getParticipants() {
        return participants;
    }
}
