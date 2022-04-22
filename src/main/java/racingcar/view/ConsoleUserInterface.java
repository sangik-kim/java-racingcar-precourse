package racingcar.view;

import racingcar.view.printer.Printer;
import racingcar.view.scanner.Scanner;

public class ConsoleUserInterface implements GameUserInterface {

    private final Printer printer;
    private final Scanner scanner;

    public ConsoleUserInterface(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void show(String message) {
        printer.print(message);
    }

    @Override
    public String getUserInput(String message) {
        show(message);
        return scanner.read();
    }
}
