package cz.honzakasik.upol.prkl.heroc.tree.statement;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.statement.CompoundStatement;
import cz.honzakasik.upol.prkl.heroc.tree.declarator.DeclarationVisitor;

import java.util.stream.Collectors;

public class CompoundStatementVisitor extends HerocBaseVisitor<CompoundStatement> {

    private final Environment environment;

    public CompoundStatementVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public CompoundStatement visitCompoundStatement(HerocParser.CompoundStatementContext ctx) {
        return new CompoundStatement(
                ctx.declaration().stream()
                        .map(declarationContext -> declarationContext.accept(new DeclarationVisitor(environment)))
                        .collect(Collectors.toList()),
                ctx.statement().stream()
                        .map(statementContext -> statementContext.accept(new StatementVisitor(environment)))
                        .collect(Collectors.toList())
        );
    }
}
