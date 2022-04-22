package racingcar.domain.racing.car;

public class Car {
    private final Name name;
    private final int location;

    public Car(String name, int location) {
        this.name = Name.from(name);
        this.location = location;
    }
}
