package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionDefinition;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionSignature;
import cz.honzakasik.upol.prkl.heroc.model.statement.CompoundStatement;
import cz.honzakasik.upol.prkl.heroc.tree.declarator.DeclarationVisitor;
import cz.honzakasik.upol.prkl.heroc.tree.statement.StatementVisitor;

import java.util.stream.Collectors;

public class FunctionDefinitionVisitor extends HerocBaseVisitor<FunctionDefinition> {

    private Environment environment;

    /**
     * Creates new instance
     * @param environment lexically superior environment
     */
    public FunctionDefinitionVisitor(Environment environment) {
        this.environment = new Environment(environment);
    }

    @Override
    public FunctionDefinition visitFunctionDefinition(HerocParser.FunctionDefinitionContext ctx) {
        final FunctionSignature functionSignature = ctx.accept(new SignatureVisitor(environment));

        final FunctionDefinition functionDefinition = new FunctionDefinition(functionSignature,
                getFunctionBodyFromContext(ctx));

        environment.addFunctionDefinition(functionDefinition);

        return functionDefinition;
    }

    private CompoundStatement getFunctionBodyFromContext(HerocParser.FunctionDefinitionContext ctx) {
        return new CompoundStatement(
                ctx.functionBody.declaration().stream()
                    .map(declarationContext -> declarationContext.accept(new DeclarationVisitor(environment)))
                    .collect(Collectors.toList()),
                ctx.functionBody.statement().stream()
                    .map(statementContext -> statementContext.accept(new StatementVisitor(environment)))
                    .collect(Collectors.toList())
        );
    }


}
