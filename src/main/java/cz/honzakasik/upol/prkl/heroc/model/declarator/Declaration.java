package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;

public class Declaration extends Node {

    private final List<InitDeclarator> initDeclarators;

    public Declaration(List<InitDeclarator> initDeclarators) {
        this.initDeclarators = initDeclarators;
    }

    public List<InitDeclarator> getInitDeclarators() {
        return initDeclarators;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("initDeclarators:", depth);
        initDeclarators.forEach(initDeclarator -> initDeclarator.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
    }
}
