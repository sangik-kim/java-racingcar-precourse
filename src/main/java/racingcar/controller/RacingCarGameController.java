package racingcar.controller;

import racingcar.dto.CarNames;
import racingcar.dto.TryCount;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {
    private final RacingCarGameView racingCarGameView;

    public RacingCarGameController(RacingCarGameView racingCarGameView) {
        this.racingCarGameView = racingCarGameView;
    }

    public void start() {
        CarNames carNames = racingCarGameView.getCarNames();
        TryCount tryCount = racingCarGameView.getTryCount();
    }
}
