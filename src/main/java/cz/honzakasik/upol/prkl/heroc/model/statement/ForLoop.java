package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class ForLoop implements Statement{

    private Expression initializer;
    private Expression condition;
    private Expression afterCycle;
    private Statement cycle;

    public ForLoop(Expression initializer, Expression condition, Expression afterCycle, Statement cycle) {
        this.initializer = initializer;
        this.condition = condition;
        this.afterCycle = afterCycle;
        this.cycle = cycle;
    }

    public Expression getInitializer() {
        return initializer;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getAfterCycle() {
        return afterCycle;
    }

    public Statement getCycle() {
        return cycle;
    }
}