package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

import java.util.List;

public class Initializer {

    private final Expression expression;
    private final List<Initializer> initializerList;

    public Initializer(Expression expression, List<Initializer> initializerList) {
        this.expression = expression;
        this.initializerList = initializerList;
    }

    public Expression getExpression() {
        return expression;
    }

    public List<Initializer> getInitializerList() {
        return initializerList;
    }
}
