package cz.honzakasik.upol.prkl.heroc.model.expression;

import cz.honzakasik.upol.prkl.heroc.model.expression.arithmetic.Operator;

public class RelationalExpression implements BinaryExpression{

    private Expression leftSide;
    private Expression rightSide;
    private Operator operator;

    public RelationalExpression(Expression leftSide, Expression rightSide, Operator operator) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.operator = operator;
    }

    @Override
    public Expression getLeftSide() {
        return leftSide;
    }

    @Override
    public Expression getRightSide() {
        return rightSide;
    }

    @Override
    public Operator getOperator() {
        return operator;
    }
}
