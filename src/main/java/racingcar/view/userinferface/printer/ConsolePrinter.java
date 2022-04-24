package racingcar.view.userinferface.printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
