package cz.honzakasik.upol.prkl.heroc.model;

import java.util.List;

public class TranslationUnit {

    private List<Declaration> declarations;
    private List<FunctionDefinition> functionDefinitions;

    //TODO environment??
    public TranslationUnit(List<Declaration> declarations, List<FunctionDefinition> functionDefinitions) {
        this.declarations = declarations;
        this.functionDefinitions = functionDefinitions;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public List<FunctionDefinition> getFunctionDefinitions() {
        return functionDefinitions;
    }
}
