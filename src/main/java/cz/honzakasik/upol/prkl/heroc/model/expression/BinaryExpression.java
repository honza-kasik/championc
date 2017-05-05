package cz.honzakasik.upol.prkl.heroc.model.expression;

public class BinaryExpression implements Expression{

    private Expression leftSide;
    private Expression rightSide;
    private String operator;

    public BinaryExpression(Expression leftSide, Expression rightSide, String operator) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.operator = operator;
    }

    public Expression getLeftSide() {
        return leftSide;
    }

    public Expression getRightSide() {
        return rightSide;
    }

    public String getOperator() {
        return operator;
    }
}
