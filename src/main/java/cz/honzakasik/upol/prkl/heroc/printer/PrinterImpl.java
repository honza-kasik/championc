package cz.honzakasik.upol.prkl.heroc.printer;

class PrinterImpl implements Printer {

    @Override
    public void print(String text, int depth) {
        System.out.println(generateTabs(depth) + text);
    }

    private String generateTabs(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }
}
