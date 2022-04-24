package racingcar.controller;

import racingcar.domain.racing.Racing;
import racingcar.domain.racing.racer.Winner;
import racingcar.dto.CarNames;
import racingcar.dto.TryCount;
import racingcar.dto.WinnerNames;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {
    private final RacingCarGameView racingCarGameView;

    public RacingCarGameController(RacingCarGameView racingCarGameView) {
        this.racingCarGameView = racingCarGameView;
    }

    public void startGame() {
        Winner winner = startRacing();
        showWinner(winner);
    }

    private void showWinner(Winner winner) {
        racingCarGameView.showWinners(WinnerNames.from(winner));
    }

    private Winner startRacing() {
        Racing racing = Racing.from(getCarNames().get(), getTryCount().get());
        return racing.start();
    }

    private TryCount getTryCount() {
        return racingCarGameView.getTryCount();
    }

    private CarNames getCarNames() {
        return racingCarGameView.getCarNames();
    }
}
