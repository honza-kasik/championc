package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.model.declarator.AbstractDeclarator;
import cz.honzakasik.upol.prkl.heroc.model.declarator.Declarator;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ParameterDeclaration {

    private final TerminalNode typeSpecifier;
    private final Declarator declarator;
    private final AbstractDeclarator abstractDeclarator;

    public ParameterDeclaration(TerminalNode typeSpecifier, Declarator declarator, AbstractDeclarator abstractDeclarator) {
        this.typeSpecifier = typeSpecifier;
        this.declarator = declarator;
        this.abstractDeclarator = abstractDeclarator;
    }

    public TerminalNode getTypeSpecifier() {
        return typeSpecifier;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public AbstractDeclarator getAbstractDeclarator() {
        return abstractDeclarator;
    }
}
