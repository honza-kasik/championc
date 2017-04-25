package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Declaration;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionDefinition;
import cz.honzakasik.upol.prkl.heroc.model.TranslationUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Visitor for top level translation unit. Global environment is made here with all top level symbol value bonds and
 * function definitions.
 */
public class TranslationUnitVisitor extends HerocBaseVisitor<TranslationUnit> {

    private final Logger log = LoggerFactory.getLogger(TranslationUnitVisitor.class);

    @Override
    public TranslationUnit visitTranslationUnit(HerocParser.TranslationUnitContext ctx) {
        final Environment globalEnvironment = new Environment();

        final List<Declaration> declarationList = ctx.declaration().stream()
                .map(declarationContext -> declarationContext.accept(new DeclarationVisitor(globalEnvironment)))
                .peek(declaration -> log.debug("Visited '{}' declaration.", declaration.getSymbolName()))
                .collect(toList());

        final List<FunctionDefinition> functionDefinitions = ctx.functionDefinition().stream()
                .map(functionDefinitionContext -> functionDefinitionContext.accept(new FunctionDefinitionVisitor(globalEnvironment)))
                .peek(definition -> log.debug("Visited '{}' function definition.", definition.getFunctionSignature().getName()))
                .collect(toList());

        return new TranslationUnit(globalEnvironment, declarationList, functionDefinitions);
    }
}
