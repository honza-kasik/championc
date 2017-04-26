package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.DirectDeclarator;

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
