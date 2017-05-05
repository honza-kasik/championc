package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Initializer;

/**
 * Declarator containing both variable declaration and/or initializer
 */
public class InitDeclarator {

    private VariableDeclaration variableDeclaration;
    private Initializer initializer;

    public InitDeclarator(VariableDeclaration variableDeclaration, Initializer initializer) {
        this.variableDeclaration = variableDeclaration;
        this.initializer = initializer;
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public Initializer getInitializer() {
        return initializer;
    }
}
