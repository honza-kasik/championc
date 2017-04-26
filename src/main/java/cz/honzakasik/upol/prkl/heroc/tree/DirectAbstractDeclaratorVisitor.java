package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.DirectAbstractDeclarator;

import java.util.stream.Collectors;

public class DirectAbstractDeclaratorVisitor extends HerocBaseVisitor<DirectAbstractDeclarator> {

    private final Environment environment;

    public DirectAbstractDeclaratorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public DirectAbstractDeclarator visitDirectAbstractDeclarator(HerocParser.DirectAbstractDeclaratorContext ctx) {
        return new DirectAbstractDeclarator(
                ctx.abstractDeclarator().accept(new AbstractDeclaratorVisitor(environment)),
                ctx.directAbstractDeclarator().accept(new DirectAbstractDeclaratorVisitor(environment)),
                ctx.parameterDeclaration().stream()
                        .map(parameterDeclarationContext ->
                                parameterDeclarationContext.accept(new ParameterDeclarationVisitor(environment)))
                        .collect(Collectors.toList()),
                ctx.expression().accept(new ExpressionVisitor(environment))
        );
    }
}
