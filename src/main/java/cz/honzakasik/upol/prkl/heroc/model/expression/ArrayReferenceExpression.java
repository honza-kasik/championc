package cz.honzakasik.upol.prkl.heroc.model.expression;

public class ArrayReferenceExpression implements Expression {

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
}
