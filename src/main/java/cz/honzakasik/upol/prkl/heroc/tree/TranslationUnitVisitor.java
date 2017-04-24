package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Declaration;
import cz.honzakasik.upol.prkl.heroc.model.FunctionDefinition;
import cz.honzakasik.upol.prkl.heroc.model.TranslationUnit;

import java.util.List;

import static java.util.stream.Collectors.toList;

//TODO
public class TranslationUnitVisitor extends HerocBaseVisitor<TranslationUnit> {

    //TODO Scope - prostredi...
    @Override
    public TranslationUnit visitTranslationUnit(HerocParser.TranslationUnitContext ctx) {
        final Environment environment = new Environment();

        final List<Declaration> declarationList = ctx.declaration().stream()
                .map(declarationContext -> declarationContext.accept(new DeclarationVisitor()))
                .peek(declaration -> System.out.println(declaration.getSymbolName()))
                .collect(toList());
        final List<FunctionDefinition> functionDefinitions = ctx.functionDefinition().stream()
                .map(functionDefinitionContext -> functionDefinitionContext.accept(new FunctionDefinitionVisitor()))
                .collect(toList());

        return new TranslationUnit(declarationList, functionDefinitions);
    }
}
