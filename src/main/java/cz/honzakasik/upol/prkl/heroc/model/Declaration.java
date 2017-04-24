package cz.honzakasik.upol.prkl.heroc.model;

public class Declaration {

    private String symbolName;
    private String initializedValue;

    public Declaration(String symbolName, String initializedValue) {
        this.symbolName = symbolName;
        this.initializedValue = initializedValue;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public String getInitializedValue() {
        return initializedValue;
    }
}
