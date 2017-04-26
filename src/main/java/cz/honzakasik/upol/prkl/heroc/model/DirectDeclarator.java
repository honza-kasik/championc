package cz.honzakasik.upol.prkl.heroc.model;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class DirectDeclarator {

    private final Expression expression;
    private final DirectDeclarator directDeclarator;
    private final List<ParameterDeclaration> parameterDeclarations;
    private final List<TerminalNode> identifiers;

    public DirectDeclarator(Expression expression, DirectDeclarator directDeclarator,
                            List<ParameterDeclaration> parameterDeclarations, List<TerminalNode> identifiers) {
        this.expression = expression;
        this.directDeclarator = directDeclarator;
        this.parameterDeclarations = parameterDeclarations;
        this.identifiers = identifiers;
    }

    public Expression getExpression() {
        return expression;
    }

    public DirectDeclarator getDirectDeclarator() {
        return directDeclarator;
    }

    public List<ParameterDeclaration> getParameterDeclarations() {
        return parameterDeclarations;
    }

    public List<TerminalNode> getIdentifiers() {
        return identifiers;
    }
}
