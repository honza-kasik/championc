package cz.honzakasik.upol.prkl.heroc.model;

import java.util.List;

public class Declaration {

    private final List<InitDeclarator> initDeclarators;

    public Declaration(List<InitDeclarator> initDeclarators) {
        this.initDeclarators = initDeclarators;
    }

    public List<InitDeclarator> getInitDeclarators() {
        return initDeclarators;
    }
}
