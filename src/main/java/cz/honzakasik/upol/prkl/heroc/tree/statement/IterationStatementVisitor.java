package cz.honzakasik.upol.prkl.heroc.tree.statement;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.statement.DoWhileLoop;
import cz.honzakasik.upol.prkl.heroc.model.statement.ForLoop;
import cz.honzakasik.upol.prkl.heroc.model.statement.Statement;
import cz.honzakasik.upol.prkl.heroc.model.statement.WhileLoop;
import cz.honzakasik.upol.prkl.heroc.tree.expression.ExpressionVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

public class IterationStatementVisitor extends HerocBaseVisitor<Statement> {

    private enum CycleType {
        DO_WHILE("do"),
        WHILE("while"),
        FOR("for");

        private String keyword;

        CycleType(String keyword) {
            this.keyword = keyword;
        }

        public String getKeyword() {
            return keyword;
        }
    }

    private final Environment environment;

    public IterationStatementVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Statement visitIterationStatement(HerocParser.IterationStatementContext ctx) {
        ParseTree cycleType = ctx.getChild(0);
        if (cycleType.getText().equals(CycleType.DO_WHILE.getKeyword())) {
            return new DoWhileLoop(
                    ctx.expression().get(0).accept(new ExpressionVisitor(environment)),
                    ctx.statement().accept(new StatementVisitor(environment))
            );
        } else if (cycleType.getText().equals(CycleType.WHILE.getKeyword())) {
            return new WhileLoop(
                    ctx.expression().get(0).accept(new ExpressionVisitor(environment)),
                    ctx.statement().accept(new StatementVisitor(environment))
            );
        } else {
            return new ForLoop(
                    ctx.expression().get(0).accept(new ExpressionVisitor(environment)),
                    ctx.expression().get(1).accept(new ExpressionVisitor(environment)),
                    ctx.expression().get(2).accept(new ExpressionVisitor(environment)),
                    ctx.statement().accept(new StatementVisitor(environment))
            );
        }
    }
}
