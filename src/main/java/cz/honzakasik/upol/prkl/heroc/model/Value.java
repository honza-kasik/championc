package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class Value implements Expression {

    private long value;

    public Value(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
