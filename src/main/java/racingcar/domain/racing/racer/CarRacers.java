package racingcar.domain.racing.racer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.AcceleratorGenerator;

public class CarRacers {
    private final Map<Racer, Car> carRacers;

    CarRacers(Map<Racer, Car> carRacers) {
        this.carRacers = carRacers;
    }

    private CarRacers(Cars cars, AcceleratorGenerator acceleratorGenerator) {
        carRacers = generateRacers(cars, acceleratorGenerator);
    }

    public static CarRacers from(Cars cars, AcceleratorGenerator acceleratorGenerator) {
        return new CarRacers(cars, acceleratorGenerator);
    }

    public CarRacers race() {
        Map<Racer, Car> racerCarMap = new LinkedHashMap<>();
        for (Racer racer : carRacers.keySet()) {
            Car car = carRacers.get(racer);
            racerCarMap.put(racer, racer.drive(car));
        }
        return new CarRacers(racerCarMap);
    }

    public Winner getWinner() {
        List<Car> participants = new ArrayList<>();
        carRacers.values().forEach(participants::add);
        return Winner.find(participants);
    }

    private Map<Racer, Car> generateRacers(Cars cars, AcceleratorGenerator acceleratorGenerator) {
        Map<Racer, Car> racerCarMap = new LinkedHashMap<>();
        for (Car car : cars.getCars()) {
            racerCarMap.put(Racer.from(acceleratorGenerator), car);
        }
        return racerCarMap;
    }
}
