package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Pointer;

public class Declarator {

    private final Pointer pointerList;
    private final DirectDeclarator directDeclarator;

    public Declarator(Pointer pointerList, DirectDeclarator directDeclarator) {
        this.pointerList = pointerList;
        this.directDeclarator = directDeclarator;
    }

    public Pointer getPointerList() {
        return pointerList;
    }

    public DirectDeclarator getDirectDeclarator() {
        return directDeclarator;
    }
}
