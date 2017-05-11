package cz.honzakasik.upol.prkl.heroc.tree.statement;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.model.statement.DoWhileLoop;
import cz.honzakasik.upol.prkl.heroc.model.statement.ForLoop;
import cz.honzakasik.upol.prkl.heroc.model.statement.Statement;
import cz.honzakasik.upol.prkl.heroc.model.statement.WhileLoop;
import cz.honzakasik.upol.prkl.heroc.tree.expression.ExpressionVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IterationStatementVisitor extends HerocBaseVisitor<Statement> {

    private static final Logger log = LoggerFactory.getLogger(IterationStatementVisitor.class);

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
            Expression declarator = ctx.forDeclarator == null ? null :
                    ctx.forDeclarator.accept(new ExpressionVisitor(environment));
            Expression condition = ctx.forCondition == null ? null :
                    ctx.forCondition.accept(new ExpressionVisitor(environment));
            Expression iterator = ctx.forIterator == null ? null :
                    ctx.forIterator.accept(new ExpressionVisitor(environment));
            return new ForLoop(
                    declarator,
                    condition,
                    iterator,
                    ctx.statement().accept(new StatementVisitor(environment))
            );
        }
    }
}
