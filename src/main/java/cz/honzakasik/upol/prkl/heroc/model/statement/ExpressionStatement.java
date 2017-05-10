package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class ExpressionStatement extends Node implements Statement {

    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }

    public ExpressionStatement() {
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        if (expression != null) {
            expression.appendStringRepresentationToBuilder(outputBuilder, depth);
        }
    }
}
