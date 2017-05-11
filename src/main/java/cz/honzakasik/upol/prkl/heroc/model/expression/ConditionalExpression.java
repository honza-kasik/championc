package cz.honzakasik.upol.prkl.heroc.model.expression;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class ConditionalExpression extends Node implements Expression {

    private Expression condition;
    private Expression trueBranch;
    private Expression falseBranch;

    public ConditionalExpression(Expression condition, Expression trueBranch, Expression falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getTrueBranch() {
        return trueBranch;
    }

    public Expression getFalseBranch() {
        return falseBranch;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(ConditionalExpression.class, depth)
                .append("condition:", depth);
        condition.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        outputBuilder.append("trueBranch", depth);
        trueBranch.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        outputBuilder.append("falseBranch", depth);
        falseBranch.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
    }
}
