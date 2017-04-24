package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.model.Declaration;
import cz.honzakasik.upol.prkl.heroc.model.FunctionDefinition;
import cz.honzakasik.upol.prkl.heroc.model.TranslationUnit;

import java.util.LinkedList;
import java.util.List;

public class TranslationUnitVisitor extends HerocBaseVisitor<TranslationUnit> {

    @Override
    public TranslationUnit visitTranslationUnit(HerocParser.TranslationUnitContext ctx) {
        final List<Declaration> declarationList = new LinkedList<>();
        final List<FunctionDefinition> functionDefinitions = new LinkedList<>();
        final List<HerocParser.DeclarationContext> declarationContexts = new LinkedList<>();
        final List<HerocParser.FunctionDefinitionContext> functionDefinitionContexts = new LinkedList<>();
        ctx.getRuleContexts(HerocParser.ExternalDeclarationContext.class).stream()
                .forEachOrdered(
                        context -> {
                            declarationContexts.addAll(context.getRuleContexts(HerocParser.DeclarationContext.class));
                            functionDefinitionContexts.addAll(context.getRuleContexts(HerocParser.FunctionDefinitionContext.class));
                        }
                );
        return new TranslationUnit(declarationList, functionDefinitions);
    }


}
