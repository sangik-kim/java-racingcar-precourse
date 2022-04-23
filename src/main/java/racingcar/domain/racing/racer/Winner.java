package racingcar.domain.racing.racer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.Cars;

public class Winner {
    private final Cars winners;

    private Winner(List<Car> allParticipants) {
        this.winners = Cars.from(findWinners(allParticipants));
    }

    public static Winner find(List<Car> allParticipants) {
        return new Winner(allParticipants);
    }

    public List<Car> getWinners() {
        return winners.getCars();
    }

    private List<Car> findWinners(List<Car> allParticipants) {
        int locationOfWinner = findLocationOfWinner(allParticipants);

        List<Car> winners = new ArrayList<>();
        for (Car car : allParticipants) {
            checkIfWinner(car, locationOfWinner).ifPresent((winner) -> winners.add(winner));
        }
        return winners;
    }

    private int findLocationOfWinner(List<Car> allParticipants) {
        int locationOfWinner = Collections.max(allParticipants, Comparator.comparingInt(Car::getLocation))
                .getLocation();
        return locationOfWinner;
    }

    private Optional<Car> checkIfWinner(Car car, int locationOfWinner) {
        return locationOfWinner == car.getLocation() ? Optional.ofNullable(car) : Optional.empty();
    }
}
