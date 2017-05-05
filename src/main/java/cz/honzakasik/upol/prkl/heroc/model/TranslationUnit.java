package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.Declaration;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionDefinition;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class TranslationUnit extends Node {

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

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(TranslationUnit.class, depth)
                .append("declarations:", depth);
        declarations.forEach(declaration -> declaration.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
        outputBuilder.append("functionDefinitions:", depth);
        functionDefinitions.forEach(functionDefinition -> functionDefinition.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
    }
}
