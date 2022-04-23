package racingcar.domain.racing.car;

import java.util.Objects;

public class Location {
    private final int location;

    public Location(int location) {
        this.location = location;
    }

    public static Location from(int location) {
        return new Location(location);
    }

    public Location add(int distance) {
        return new Location(location + distance);
    }

    int get() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
