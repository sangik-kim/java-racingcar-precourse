package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.view.RacingCarGameView;
import racingcar.view.userinferface.ConsoleUserInterface;
import racingcar.view.userinferface.GameUserInterface;
import racingcar.view.userinferface.printer.ConsolePrinter;
import racingcar.view.userinferface.scanner.ConsoleScanner;

public class Application {
    public static void main(String[] args) {
        GameUserInterface gameUserInterface = new ConsoleUserInterface(new ConsolePrinter(), new ConsoleScanner());
        RacingCarGameView gameView = new RacingCarGameView(gameUserInterface);

        RacingCarGameController gameController = new RacingCarGameController(gameView);
        gameController.start();
    }
}
