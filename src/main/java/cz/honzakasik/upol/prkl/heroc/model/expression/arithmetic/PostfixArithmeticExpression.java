package cz.honzakasik.upol.prkl.heroc.model.expression.arithmetic;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.model.expression.UnaryExpression;

public class PostfixArithmeticExpression extends UnaryExpression {

    public PostfixArithmeticExpression(String operator, Expression expression) {
        super(operator, expression);
    }
}
