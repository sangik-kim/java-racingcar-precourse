package racingcar.domain.racing.car.accelerator.generator;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.racing.car.accelerator.Accelerator;

public class RandomAcceleratorGenerator implements AcceleratorGenerator {
    private static final int MINIMUM_POWER = 0;
    private static final int MAXIMUM_POWER = 9;

    private RandomAcceleratorGenerator() {
    }

    public static RandomAcceleratorGenerator create() {
        return new RandomAcceleratorGenerator();
    }

    @Override
    public Accelerator generate() {
        return Accelerator.from(Randoms.pickNumberInRange(MINIMUM_POWER, MAXIMUM_POWER));
    }
}
