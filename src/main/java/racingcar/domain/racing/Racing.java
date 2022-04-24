package racingcar.domain.racing;

import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.RandomAcceleratorGenerator;
import racingcar.domain.racing.racer.CarRacers;
import racingcar.domain.racing.racer.Winner;

public class Racing {
    private final Cars participants;
    private final TryCount tryCount;

    private Racing(String carNames, int tryCount) {
        this.participants = Cars.from(carNames);
        this.tryCount = TryCount.from(tryCount);
    }

    public static Racing from(String carNames, int tryCount) {
        return new Racing(carNames, tryCount);
    }

    public Winner start() {
        CarRacers carRacers = createCarRacers();
        return race(carRacers);
    }

    public Cars getParticipants() {
        return participants;
    }

    private Winner race(CarRacers carRacers) {
        for (int i = 0; i < tryCount.get(); i++) {
            carRacers = carRacers.race();
        }
        return carRacers.getWinner();
    }

    private CarRacers createCarRacers() {
        CarRacers carRacers = CarRacers.from(participants, RandomAcceleratorGenerator.create());
        return carRacers;
    }
}
