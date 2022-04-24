package racingcar.controller;

import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingResult;
import racingcar.domain.racing.racer.Winner;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.dto.response.WinnerNames;
import racingcar.dto.response.RacingTryResult;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {
    private final RacingCarGameView racingCarGameView;

    public RacingCarGameController(RacingCarGameView racingCarGameView) {
        this.racingCarGameView = racingCarGameView;
    }

    public void startGame() {
        RacingResult result = startRacing();
        showTryResults(result);
        showWinner(result.getWinner());
    }

    private void showTryResults(RacingResult result) {
        racingCarGameView.showResult();
        result.getHistory().get().forEach(cars -> racingCarGameView.showTryResult(RacingTryResult.from(cars)));
    }

    private void showWinner(Winner winner) {
        racingCarGameView.showWinners(WinnerNames.from(winner));
    }

    private RacingResult startRacing() {
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
