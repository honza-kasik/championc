package cz.honzakasik.upol.prkl.heroc.model.expression;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class BinaryExpression extends Node implements Expression{

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


    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass().getSimpleName() + ":", depth)
                .append("operator: " + operator, depth + 1)
                .append("leftSide:", depth + 1);
        leftSide.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        outputBuilder.append("rightSide:", depth + 1);
        rightSide.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
    }
}
