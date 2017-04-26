package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.statement.Statement;

//TODO Override methods
public class StatementVisitor extends HerocBaseVisitor<Statement> {

    private Environment environment;

    public StatementVisitor(Environment parentEnvironment) {

    }

    @Override
    public Statement visitStatement(HerocParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public Statement visitLabeledStatement(HerocParser.LabeledStatementContext ctx) {
        return super.visitLabeledStatement(ctx);
    }

    @Override
    public Statement visitCompoundStatement(HerocParser.CompoundStatementContext ctx) {
        return super.visitCompoundStatement(ctx);
    }

    @Override
    public Statement visitExpressionStatement(HerocParser.ExpressionStatementContext ctx) {
        return super.visitExpressionStatement(ctx);
    }

    @Override
    public Statement visitSelectionStatement(HerocParser.SelectionStatementContext ctx) {
        return super.visitSelectionStatement(ctx);
    }

    @Override
    public Statement visitIterationStatement(HerocParser.IterationStatementContext ctx) {
        return super.visitIterationStatement(ctx);
    }

    @Override
    public Statement visitJumpStatement(HerocParser.JumpStatementContext ctx) {
        return super.visitJumpStatement(ctx);
    }
}
