package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class DoWhileLoop extends Node implements Statement {

    private Expression condition;
    private Statement cycle;

    public DoWhileLoop(Expression condition, Statement cycle) {
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
