package cz.honzakasik.upol.prkl.heroc.model.expression;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

public class ArrayReferenceExpression extends Node implements Expression {

    private Expression identifierExpression;
    private Expression referenceExpression;

    public ArrayReferenceExpression(Expression identifierExpression, Expression referenceExpression) {
        this.identifierExpression = identifierExpression;
        this.referenceExpression = referenceExpression;
    }

    public Expression getIdentifierExpression() {
        return identifierExpression;
    }

    public Expression getReferenceExpression() {
        return referenceExpression;
    }


    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass().getSimpleName() + ":", depth)
                .append("identifierExpression:", depth);
        identifierExpression.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        outputBuilder.append("referenceExpression:", depth);
        referenceExpression.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
    }
}
