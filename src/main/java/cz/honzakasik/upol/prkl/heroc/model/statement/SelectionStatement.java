package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class SelectionStatement implements Statement {

    private Expression condition;
    private Statement primaryStatement;
    /**
     * In else branch
     */
    private Statement secondaryStatement;

    public SelectionStatement(Expression condition, Statement primaryStatement, Statement secondaryStatement) {
        this.condition = condition;
        this.primaryStatement = primaryStatement;
        this.secondaryStatement = secondaryStatement;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getPrimaryStatement() {
        return primaryStatement;
    }

    public Statement getSecondaryStatement() {
        return secondaryStatement;
    }
}
