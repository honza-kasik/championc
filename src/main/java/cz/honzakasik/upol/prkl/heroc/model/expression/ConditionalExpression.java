package cz.honzakasik.upol.prkl.heroc.model.expression;

public class ConditionalExpression implements Expression {

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
}
