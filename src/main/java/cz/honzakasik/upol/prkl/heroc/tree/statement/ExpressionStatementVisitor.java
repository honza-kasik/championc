package cz.honzakasik.upol.prkl.heroc.tree.statement;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.statement.ExpressionStatement;
import cz.honzakasik.upol.prkl.heroc.tree.expression.ExpressionVisitor;

public class ExpressionStatementVisitor extends HerocBaseVisitor<ExpressionStatement> {

    private Environment environment;

    public ExpressionStatementVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public ExpressionStatement visitExpressionStatement(HerocParser.ExpressionStatementContext ctx) {
        if (ctx.expression() != null) {
            return new ExpressionStatement(ctx.expression().accept(new ExpressionVisitor(environment)));
        } else {
            return new ExpressionStatement();
        }
    }
}
