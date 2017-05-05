package cz.honzakasik.upol.prkl.heroc.tree.statement;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.statement.JumpStatement;
import cz.honzakasik.upol.prkl.heroc.model.statement.Statement;
import cz.honzakasik.upol.prkl.heroc.tree.expression.ExpressionVisitor;

public class StatementVisitor extends HerocBaseVisitor<Statement> {

    private Environment environment;

    public StatementVisitor(Environment parentEnvironment) {
        this.environment = parentEnvironment;
    }

    @Override
    public Statement visitCompoundStatement(HerocParser.CompoundStatementContext ctx) {
        return new CompoundStatementVisitor(environment).visitCompoundStatement(ctx);
    }

    @Override
    public Statement visitExpressionStatement(HerocParser.ExpressionStatementContext ctx) {
        return new ExpressionStatementVisitor(environment).visitExpressionStatement(ctx);
    }

    @Override
    public Statement visitSelectionStatement(HerocParser.SelectionStatementContext ctx) {
        return new IfStatementVisitor(environment).visitSelectionStatement(ctx);
    }

    @Override
    public Statement visitIterationStatement(HerocParser.IterationStatementContext ctx) {
        return new IterationStatementVisitor(environment).visitIterationStatement(ctx);
    }

    @Override
    public Statement visitJumpStatement(HerocParser.JumpStatementContext ctx) {
        final String keyword = ctx.getChild(0).getText();
        JumpStatement.Type type;
        if (keyword.equals(JumpStatement.Type.RETURN.getKeyword())) {
            type = JumpStatement.Type.RETURN;
        } else if (keyword.equals(JumpStatement.Type.BREAK.getKeyword())) {
            type = JumpStatement.Type.BREAK;
        } else {
            type = JumpStatement.Type.CONTINUE;
        }

        if (ctx.getChildCount() > 1) {
            return new JumpStatement(type, ctx.expression().accept(new ExpressionVisitor(environment)));
        } else {
            return new JumpStatement(type);
        }
    }
}
