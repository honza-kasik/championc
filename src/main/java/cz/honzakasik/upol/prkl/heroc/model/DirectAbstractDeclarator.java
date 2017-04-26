package cz.honzakasik.upol.prkl.heroc.model;

import java.util.List;

public class DirectAbstractDeclarator {

    private final AbstractDeclarator abstractDeclarator;
    private final DirectAbstractDeclarator directAbstractDeclarator;
    private final List<ParameterDeclaration> parameterDeclaration;
    private final Expression expression;

    public DirectAbstractDeclarator(AbstractDeclarator abstractDeclarator, DirectAbstractDeclarator directAbstractDeclarator,
                                    List<ParameterDeclaration> parameterDeclaration, Expression expression) {
        this.abstractDeclarator = abstractDeclarator;
        this.directAbstractDeclarator = directAbstractDeclarator;
        this.parameterDeclaration = parameterDeclaration;
        this.expression = expression;
    }

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() {
        return directAbstractDeclarator;
    }

    public List<ParameterDeclaration> getParameterDeclaration() {
        return parameterDeclaration;
    }

    public Expression getExpression() {
        return expression;
    }
}
