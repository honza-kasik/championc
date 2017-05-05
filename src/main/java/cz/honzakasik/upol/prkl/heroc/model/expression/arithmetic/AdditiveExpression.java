package cz.honzakasik.upol.prkl.heroc.model.expression.arithmetic;

import cz.honzakasik.upol.prkl.heroc.model.expression.BinaryExpression;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class AdditiveExpression extends BinaryExpression {

    public AdditiveExpression(Expression leftSide, Expression rightSide, Operator operator) {
        super(leftSide, rightSide, operator);
    }
}

