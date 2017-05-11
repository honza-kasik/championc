package cz.honzakasik.upol.prkl.heroc.printer;

public class PrinterFactory {

    public static Printer getPrinter() {
        return new PrinterImpl();
    }

}
