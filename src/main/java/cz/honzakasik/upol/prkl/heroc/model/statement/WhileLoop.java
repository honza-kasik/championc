package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class WhileLoop implements Statement {

    private Expression condition;
    private Statement cycle;

    public WhileLoop(Expression condition, Statement cycle) {
        this.condition = condition;
        this.cycle = cycle;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getCycle() {
        return cycle;
    }
}
