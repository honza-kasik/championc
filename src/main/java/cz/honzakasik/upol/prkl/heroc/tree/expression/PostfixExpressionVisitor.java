package cz.honzakasik.upol.prkl.heroc.tree.expression;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.expression.ArrayReferenceExpression;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.model.expression.arithmetic.PostfixArithmeticExpression;

public class PostfixExpressionVisitor extends HerocBaseVisitor<Expression> {

    private Environment environment;

    public PostfixExpressionVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Expression visitPostfixExpression(HerocParser.PostfixExpressionContext ctx) {
        if (ctx.getChild(0) instanceof HerocParser.PostfixExpressionContext) {
            if (ctx.getChildCount() == 2) {
                return new PostfixArithmeticExpression(
                        ctx.getChild(1).getText(),
                        ctx.postfixExpression().accept(new ExpressionVisitor(environment))
                );
            } else {
                return new ArrayReferenceExpression(
                        ctx.postfixExpression().accept(new PostfixExpressionVisitor(environment)),
                        ctx.expression().accept(new ExpressionVisitor(environment))
                );
            }
        } else {
            return ctx.primaryExpression().accept(new ExpressionVisitor(environment));
        }
    }
}
