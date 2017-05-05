package cz.honzakasik.upol.prkl.heroc.tree.expression;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Value;
import cz.honzakasik.upol.prkl.heroc.model.VariableReference;
import cz.honzakasik.upol.prkl.heroc.model.expression.*;

public class ExpressionVisitor extends HerocBaseVisitor<Expression> {

    private final Environment environment;

    public ExpressionVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Expression visitPrimaryExpression(HerocParser.PrimaryExpressionContext ctx) {
        if (ctx.ID() != null) {
            return new VariableReference(ctx.ID().getText());
        } else if (ctx.NUMBER() != null) {
            return new Value(ctx.NUMBER().getText());
        } else if (ctx.STRING() != null) {
            return new Value(ctx.STRING().getText());
        } else if (ctx.CHAR_CONSTANT() != null) {
            return new Value(ctx.CHAR_CONSTANT().getText());
        } else {
            return ctx.expression().accept(new ExpressionVisitor(environment));
        }
    }

    @Override
    public Expression visitPostfixExpression(HerocParser.PostfixExpressionContext ctx) {
        return new PostfixExpressionVisitor(environment).visitPostfixExpression(ctx);
    }

    @Override
    public Expression visitUnaryExpression(HerocParser.UnaryExpressionContext ctx) {
        if (ctx.getChild(0) instanceof HerocParser.PostfixExpressionContext) {
            return visitPostfixExpression(ctx.postfixExpression());
        } else {
            if (ctx.getChildCount() == 2) {
                return new UnaryExpression(
                        ctx.getChild(0).getText(),
                        visitUnaryExpression(ctx.unaryExpression())
                );
            } else {
                return new SizeOfExpression();
            }
        }
    }

    @Override
    public Expression visitAdditiveExpression(HerocParser.AdditiveExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitRelationalExpression(HerocParser.RelationalExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitLogicalAndExpression(HerocParser.LogicalAndExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitInclusiveOrExpression(HerocParser.InclusiveOrExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitPrimaryExpressionL(HerocParser.PrimaryExpressionLContext ctx) {
        return visitPrimaryExpression(ctx.primaryExpression());
    }

    @Override
    public Expression visitLogicalOrExpression(HerocParser.LogicalOrExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitConditionalExpression(HerocParser.ConditionalExpressionContext ctx) {
        return new ConditionalExpression(
                ctx.expression(0).accept(new ExpressionVisitor(environment)),
                ctx.expression(1).accept(new ExpressionVisitor(environment)),
                ctx.expression(2).accept(new ExpressionVisitor(environment))
        );
    }

    @Override
    public Expression visitExclusiveOrExpression(HerocParser.ExclusiveOrExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitShiftExpression(HerocParser.ShiftExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitAndExpression(HerocParser.AndExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitAssignmentExpression(HerocParser.AssignmentExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitUnaryExpressionL(HerocParser.UnaryExpressionLContext ctx) {
        return visitUnaryExpression(ctx.unaryExpression());
    }

    @Override
    public Expression visitEqualityExpression(HerocParser.EqualityExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    @Override
    public Expression visitMultiplicativeExpression(HerocParser.MultiplicativeExpressionContext ctx) {
        return visitBinaryExpression(ctx);
    }

    private BinaryExpression visitBinaryExpression(HerocParser.ExpressionContext ctx) {
        return new BinaryExpression(
                ctx.getChild(0).accept(new ExpressionVisitor(environment)),
                ctx.getChild(2).accept(new ExpressionVisitor(environment)),
                ctx.getChild(1).getText()
        );
    }
}
