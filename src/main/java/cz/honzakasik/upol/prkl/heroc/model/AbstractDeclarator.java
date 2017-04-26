package cz.honzakasik.upol.prkl.heroc.model;

public class AbstractDeclarator {

    private final Pointer pointer;
    private final DirectAbstractDeclarator directAbstractDeclarator;

    public AbstractDeclarator(Pointer pointer, DirectAbstractDeclarator directAbstractDeclarator) {
        this.pointer = pointer;
        this.directAbstractDeclarator = directAbstractDeclarator;
    }

    public Pointer getPointer() {
        return pointer;
    }

    public DirectAbstractDeclarator getDirectAbstractDeclarator() {
        return directAbstractDeclarator;
    }
}
