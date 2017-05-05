package cz.honzakasik.upol.prkl.heroc.model.expression;

import cz.honzakasik.upol.prkl.heroc.model.expression.arithmetic.Operator;

public class UnaryExpression implements Expression {

    private String operator;
    private Expression expression;

    public UnaryExpression(String operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getExpression() {
        return expression;
    }
}
