package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Initializer;
import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

/**
 * Declarator containing both variable declaration and/or initializer
 */
public class InitDeclarator extends Node {

    private VariableDeclaration variableDeclaration;
    private Initializer initializer;

    public InitDeclarator(VariableDeclaration variableDeclaration, Initializer initializer) {
        this.variableDeclaration = variableDeclaration;
        this.initializer = initializer;//TODO make it Optional
    }

    public VariableDeclaration getVariableDeclaration() {
        return variableDeclaration;
    }

    public Initializer getInitializer() {
        return initializer;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("variableDeclaration:", depth);
        variableDeclaration.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        outputBuilder.append("initializer:", depth);
        if (initializer != null) {
            initializer.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        } else {
            outputBuilder.append("there is no initializer!", depth + 1);
        }
    }
}
