package racingcar.domain.racing.racer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.RandomAcceleratorGenerator;

public class CarRacersTest {
    @Test
    void 레이스가_끝나면_레이스_결과로_CarRacers를_반환한다() {
        CarRacers carRacers = CarRacers.from(Cars.from("pobi,woni,jun"), RandomAcceleratorGenerator.create()).race();
        assertThat(carRacers).isNotNull();
    }
}
