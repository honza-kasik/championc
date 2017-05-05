package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.DirectAbstractDeclarator;
import cz.honzakasik.upol.prkl.heroc.tree.expression.ExpressionVisitor;
import cz.honzakasik.upol.prkl.heroc.tree.ParameterDeclarationVisitor;

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
