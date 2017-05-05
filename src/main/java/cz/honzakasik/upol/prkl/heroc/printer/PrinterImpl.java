package cz.honzakasik.upol.prkl.heroc.printer;

class PrinterImpl implements Printer {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
