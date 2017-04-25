package cz.honzakasik.upol.prkl.heroc.model.function;

import cz.honzakasik.upol.prkl.heroc.model.statement.CompoundStatement;

import java.util.List;

public class FunctionDefinition {

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
}
