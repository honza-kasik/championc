package cz.honzakasik.upol.prkl.heroc.tree.statement;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.model.statement.IfStatement;
import cz.honzakasik.upol.prkl.heroc.model.statement.Statement;
import cz.honzakasik.upol.prkl.heroc.tree.ExpressionVisitor;

public class IfStatementVisitor extends HerocBaseVisitor<IfStatement> {

    private Environment environment;

    public IfStatementVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public IfStatement visitSelectionStatement(HerocParser.SelectionStatementContext ctx) {
        final Expression condition = ctx.expression().accept(new ExpressionVisitor(environment));
        final Statement trueStatement = ctx.statement(0).accept(new StatementVisitor(environment));
        if (ctx.statement().size() > 1) {
            return new IfStatement(condition, trueStatement,
                    ctx.statement(1).accept(new StatementVisitor(environment)));
        } else {
            return new IfStatement(condition, trueStatement);
        }
    }
}
