package racingcar.domain.racing.car;

public class Car {
    private static final int MINIMUM_GO_VALUE = 4;
    private static final int INCREMENT = 1;

    private final Name name;
    private final Location location;

    private Car(String name, int location) {
        this.name = Name.from(name);
        this.location = Location.from(location);
    }

    public static Car of(String name, int location) {
        return new Car(name, location);
    }

    public Car accelerate(int accelerator) {
        return accelerator < MINIMUM_GO_VALUE ? this : new Car(getName(), getLocation() + INCREMENT);
    }

    int getLocation() {
        return location.get();
    }

    String getName() {
        return name.toString();
    }
}
