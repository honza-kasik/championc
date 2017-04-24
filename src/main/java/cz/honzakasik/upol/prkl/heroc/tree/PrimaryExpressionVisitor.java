package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class PrimaryExpressionVisitor extends HerocBaseVisitor {

    @Override
    public Object visitPrimaryExpression(HerocParser.PrimaryExpressionContext ctx) {
        ParserRuleContext parent = ctx.getParent();
        while (parent.getChildCount() == 1) {
            parent.removeLastChild();
            parent.addChild(ctx);
            parent = parent.getParent();
        }
        return super.visitPrimaryExpression(ctx);
    }
}
