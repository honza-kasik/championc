package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;

public class Initializer extends Node {

    private final Expression expression;
    private final List<Initializer> initializerList;

    public Initializer(Expression expression, List<Initializer> initializerList) {
        this.expression = expression;
        this.initializerList = initializerList;
    }

    public Expression getExpression() {
        return expression;
    }

    public List<Initializer> getInitializerList() {
        return initializerList;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth);
        if (expression != null) {
            outputBuilder.append("expression:", depth);
            expression.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        }
        outputBuilder.append("initializerList:", depth);
        initializerList.forEach(initializer -> initializer.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
    }
}
