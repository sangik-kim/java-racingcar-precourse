package racingcar.domain.racing.car;

public class Location {
    private final int location;

    public Location(int location) {
        this.location = location;
    }

    public static Location from(int location) {
        return new Location(location);
    }

    int get() {
        return location;
    }
}
