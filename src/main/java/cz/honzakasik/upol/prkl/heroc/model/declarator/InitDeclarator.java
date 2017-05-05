package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Initializer;
import cz.honzakasik.upol.prkl.heroc.model.TypeSpecifier;

/**
 * Declarator containing both variable declaration and/or initializer
 */
public class InitDeclarator {

    private VariableDeclaration variableDeclaration;
    private TypeSpecifier typeSpecifier;
    private Initializer initializer;

    public InitDeclarator(VariableDeclaration variableDeclaration, TypeSpecifier typeSpecifier, Initializer initializer) {
        this.variableDeclaration = variableDeclaration;
        this.typeSpecifier = typeSpecifier;
        this.initializer = initializer;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public TypeSpecifier getTypeSpecifier() {
        return typeSpecifier;
    }

    public Initializer getInitializer() {
        return initializer;
    }
}
