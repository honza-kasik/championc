package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;
import cz.honzakasik.upol.prkl.heroc.printer.PrintableNode;

public abstract class Node implements PrintableNode {

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass().getSimpleName() + " is not implemented yet!!", depth);
    }
}
