package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class DoWhileLoop extends Node implements Statement {

    private Expression condition;
    private Statement cycle;

    public DoWhileLoop(Expression condition, Statement cycle) {
        this.condition = condition;
        this.cycle = cycle;
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getCycle() {
        return cycle;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(DoWhileLoop.class, depth)
                .append("condition: ", depth + 1);
        condition.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
        outputBuilder.append("cycle: ", depth + 1);
        cycle.appendStringRepresentationToBuilder(outputBuilder, depth + 2);
    }
}
