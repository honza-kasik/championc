package cz.honzakasik.upol.prkl.heroc.model;

public class InitDeclarator {

    private Declarator declarator;
    private TypeSpecifier typeSpecifier;
    private Initializer initializer;

    public InitDeclarator(Declarator declarator, TypeSpecifier typeSpecifier, Initializer initializer) {
        this.declarator = declarator;
        this.typeSpecifier = typeSpecifier;
        this.initializer = initializer;
    }

    public Declarator getDeclarator() {
        return declarator;
    }

    public TypeSpecifier getTypeSpecifier() {
        return typeSpecifier;
    }

    public Initializer getInitializer() {
        return initializer;
    }
}
