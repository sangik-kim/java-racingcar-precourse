package racingcar.view;

import static racingcar.view.constant.ViewConstant.GET_CAR_NAMES;
import static racingcar.view.constant.ViewConstant.GET_TRY_COUNT;
import static racingcar.view.constant.ViewConstant.SHOW_RESULT;

import racingcar.dto.CarNames;
import racingcar.dto.TryCount;
import racingcar.view.userinferface.GameUserInterface;

public class RacingCarGameView {
    private final GameUserInterface gameUserInterface;

    public RacingCarGameView(GameUserInterface gameUserInterface) {
        this.gameUserInterface = gameUserInterface;
    }

    public CarNames getCarNames() {
        return CarNames.from(gameUserInterface.getUserInput(GET_CAR_NAMES));
    }

    public TryCount getTryCount() {
        return TryCount.from(gameUserInterface.getUserInput(GET_TRY_COUNT));
    }

    public void showResult() {
        gameUserInterface.show(SHOW_RESULT);
    }
}
