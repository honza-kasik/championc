package cz.honzakasik.upol.prkl.heroc.model.expression;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class UnaryExpression extends Node implements Expression {

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

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("operator: '" + operator + "'", depth + 1)
                .append("expression:", depth + 1);
        expression.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
    }
}
