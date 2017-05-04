package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.Declaration;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionDefinition;

import java.util.List;

public class TranslationUnit {

    private final Environment globalEnvironment;
    private List<Declaration> declarations;
    private List<FunctionDefinition> functionDefinitions;

    public TranslationUnit(Environment globalEnvironment, List<Declaration> declarations, List<FunctionDefinition> functionDefinitions) {
        this.globalEnvironment = globalEnvironment;
        this.declarations = declarations;
        this.functionDefinitions = functionDefinitions;
    }

    public Environment getGlobalEnvironment() {
        return globalEnvironment;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public List<FunctionDefinition> getFunctionDefinitions() {
        return functionDefinitions;
    }
}
