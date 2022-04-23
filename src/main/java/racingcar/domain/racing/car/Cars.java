package racingcar.domain.racing.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final String NULL_NAME_ERROR = "자동차 이름은 null이 될 수 없습니다.";

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int STARTING_POINT = 0;

    private final List<Car> cars;

    private Cars(String carNames) {
        validateNonNull(carNames);
        cars = generateCars(carNames);
    }

    public static Cars from(String carNames) {
        return new Cars(carNames);
    }

    public int count() {
        return cars.size();
    }

    private List<Car> generateCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        List<String> carNameList = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
        for (String carName : carNameList) {
            cars.add(Car.of(carName, STARTING_POINT));
        }
        return cars;
    }

    private void validateNonNull(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(NULL_NAME_ERROR);
        }
    }
}