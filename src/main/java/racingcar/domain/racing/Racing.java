package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.RandomAcceleratorGenerator;
import racingcar.domain.racing.racer.CarRacers;

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

    public RacingResult start() {
        CarRacers carRacers = createCarRacers();
        return race(carRacers);
    }

    public Cars getParticipants() {
        return participants;
    }

    private RacingResult race(CarRacers carRacers) {
        List<Cars> history = new ArrayList<>();
        for (int i = 0; i < tryCount.get(); i++) {
            carRacers = carRacers.race();
            history.add(carRacers.getCars());
        }
        return RacingResult.of(carRacers.getWinner(), history);
    }

    private CarRacers createCarRacers() {
        CarRacers carRacers = CarRacers.from(participants, RandomAcceleratorGenerator.create());
        return carRacers;
    }
}
