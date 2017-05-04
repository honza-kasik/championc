package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class ExpressionVisitor extends HerocBaseVisitor<Expression> {

    private final Environment environment;

    public ExpressionVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Expression visitPrimaryExpression(HerocParser.PrimaryExpressionContext ctx) {
        return super.visitPrimaryExpression(ctx);
    }

    @Override
    public Expression visitPostfixExpression(HerocParser.PostfixExpressionContext ctx) {
        return super.visitPostfixExpression(ctx);
    }

    @Override
    public Expression visitUnaryExpression(HerocParser.UnaryExpressionContext ctx) {
        return super.visitUnaryExpression(ctx);
    }

    @Override
    public Expression visitAdditiveExpression(HerocParser.AdditiveExpressionContext ctx) {
        return super.visitAdditiveExpression(ctx);
    }

    @Override
    public Expression visitRelationalExpression(HerocParser.RelationalExpressionContext ctx) {
        return super.visitRelationalExpression(ctx);
    }

    @Override
    public Expression visitLogicalAndExpression(HerocParser.LogicalAndExpressionContext ctx) {
        return super.visitLogicalAndExpression(ctx);
    }

    @Override
    public Expression visitInclusiveOrExpression(HerocParser.InclusiveOrExpressionContext ctx) {
        return super.visitInclusiveOrExpression(ctx);
    }

    @Override
    public Expression visitPrimaryExpressionL(HerocParser.PrimaryExpressionLContext ctx) {
        return super.visitPrimaryExpressionL(ctx);
    }

    @Override
    public Expression visitLogicalOrExpression(HerocParser.LogicalOrExpressionContext ctx) {
        return super.visitLogicalOrExpression(ctx);
    }

    @Override
    public Expression visitConditionalExpression(HerocParser.ConditionalExpressionContext ctx) {
        return super.visitConditionalExpression(ctx);
    }

    @Override
    public Expression visitExclusiveOrExpression(HerocParser.ExclusiveOrExpressionContext ctx) {
        return super.visitExclusiveOrExpression(ctx);
    }

    @Override
    public Expression visitShiftExpression(HerocParser.ShiftExpressionContext ctx) {
        return super.visitShiftExpression(ctx);
    }

    @Override
    public Expression visitAndExpression(HerocParser.AndExpressionContext ctx) {
        return super.visitAndExpression(ctx);
    }

    @Override
    public Expression visitAssignmentExpression(HerocParser.AssignmentExpressionContext ctx) {
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public Expression visitUnaryExpressionL(HerocParser.UnaryExpressionLContext ctx) {
        return super.visitUnaryExpressionL(ctx);
    }

    @Override
    public Expression visitEqualityExpression(HerocParser.EqualityExpressionContext ctx) {
        return super.visitEqualityExpression(ctx);
    }

    @Override
    public Expression visitMultiplicativeExpression(HerocParser.MultiplicativeExpressionContext ctx) {
        return super.visitMultiplicativeExpression(ctx);
    }
}
