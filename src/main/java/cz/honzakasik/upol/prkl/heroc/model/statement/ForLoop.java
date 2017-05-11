package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class ForLoop extends Node implements Statement{

    private Expression initializer;
    private Expression condition;
    private Expression afterCycle;
    private Statement cycle;

    public ForLoop(Expression initializer, Expression condition, Expression afterCycle, Statement cycle) {
        this.initializer = initializer;
        this.condition = condition;
        this.afterCycle = afterCycle;
        this.cycle = cycle;
    }

    public Expression getInitializer() {
        return initializer;
    }

    public Expression getCondition() {
        return condition;
    }

    public Expression getAfterCycle() {
        return afterCycle;
    }

    public Statement getCycle() {
        return cycle;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(ForLoop.class, depth);
        if (initializer != null) {
            outputBuilder.append("initalizer: ", depth + 1);
            initializer.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        }
        if (condition != null) {
            outputBuilder.append("condition: ", depth + 1);
            condition.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        }
        if (afterCycle != null) {
            outputBuilder.append("iterator: ", depth + 1);
            afterCycle.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        }
        outputBuilder.append("cycle: ", depth + 1);
        cycle.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
    }
}
