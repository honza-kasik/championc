package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.DirectDeclarator;
import cz.honzakasik.upol.prkl.heroc.tree.expression.ExpressionVisitor;
import cz.honzakasik.upol.prkl.heroc.tree.ParameterDeclarationVisitor;

import java.util.stream.Collectors;

public class DirectDeclaratorVisitor extends HerocBaseVisitor<DirectDeclarator> {

    private final Environment environment;
    private final ParameterDeclarationVisitor parameterDeclarationVisitor;

    public DirectDeclaratorVisitor(Environment environment) {
        this.environment = environment;
        this.parameterDeclarationVisitor = new ParameterDeclarationVisitor(environment);
    }

    @Override
    public DirectDeclarator visitDirectDeclarator(HerocParser.DirectDeclaratorContext ctx) {
        return new DirectDeclarator(
                ctx.expression().accept(new ExpressionVisitor(environment)),
                ctx.directDeclarator().accept(new DirectDeclaratorVisitor(environment)),
                ctx.parameterDeclaration().stream()
                        .map(parameterDeclarationContext ->
                                parameterDeclarationContext.accept(parameterDeclarationVisitor))
                        .collect(Collectors.toList()),
                ctx.ID()
        );
    }
}
