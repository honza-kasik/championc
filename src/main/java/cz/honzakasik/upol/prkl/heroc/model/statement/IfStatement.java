package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.Optional;

public class IfStatement extends Node implements Statement {

    private Expression condition;
    private final Statement trueStatement;
    private final Optional<Statement> falseStatement;

    public IfStatement(Expression condition, Statement trueStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = Optional.empty();
    }

    public IfStatement(Expression condition, Statement trueStatement, Statement falseStatement) {
        this.condition = condition;
        this.trueStatement = trueStatement;
        this.falseStatement = Optional.of(falseStatement);
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getTrueStatement() {
        return trueStatement;
    }

    public Optional<Statement> getFalseStatement() {
        return falseStatement;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(IfStatement.class, depth)
                .append("condition: ", depth + 1);
        condition.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        outputBuilder.append("trueBranch: ", depth + 1);
        trueStatement.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        if (falseStatement.isPresent()) {
            outputBuilder.append("falseBranch: ", depth + 1);
            falseStatement.get().appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        }
    }
}
