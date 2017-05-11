package cz.honzakasik.upol.prkl.heroc.printer;

public class OutputBuilder {

    private final StringBuilder stringBuilder;

    public OutputBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public OutputBuilder append(String string, int depth) {
        stringBuilder.append(generateTabs(depth)).append(string).append("\n");
        return this;
    }

    public OutputBuilder append(Class<?> clazz, int depth) {
        return append(clazz.getSimpleName() + ":", depth);
    }

    private String generateTabs(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }
}
