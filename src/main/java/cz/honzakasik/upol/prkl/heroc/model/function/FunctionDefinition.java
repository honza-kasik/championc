package cz.honzakasik.upol.prkl.heroc.model.function;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.statement.CompoundStatement;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;

public class FunctionDefinition extends Node {

    private FunctionSignature functionSignature;
    private CompoundStatement functionBody;

    public FunctionDefinition(FunctionSignature functionSignature, CompoundStatement functionBody) {
        this.functionSignature = functionSignature;
        this.functionBody = functionBody;
    }

    public FunctionSignature getFunctionSignature() {
        return functionSignature;
    }

    public CompoundStatement getFunctionBody() {
        return functionBody;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("functionSignature:", depth);
        functionSignature.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
        outputBuilder.append("functionBody:", depth);
        functionBody.appendStringRepresentationToBuilder(outputBuilder, depth + 1);
    }
}
