package cz.honzakasik.upol.prkl.heroc.model.expression.arithmetic;

import cz.honzakasik.upol.prkl.heroc.model.expression.BinaryExpression;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class MultiplicativeExpression extends BinaryExpression {

    public MultiplicativeExpression(Expression leftSide, Expression rightSide, Operator operator) {
        super(leftSide, rightSide, operator);
    }
}
