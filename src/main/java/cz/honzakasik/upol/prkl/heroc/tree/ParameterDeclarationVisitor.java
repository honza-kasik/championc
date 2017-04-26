package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.ParameterDeclaration;

public class ParameterDeclarationVisitor extends HerocBaseVisitor<ParameterDeclaration>{

    private final Environment environment;

    public ParameterDeclarationVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public ParameterDeclaration visitParameterDeclaration(HerocParser.ParameterDeclarationContext ctx) {
        return new ParameterDeclaration(
                ctx.LONG(),
                ctx.declarator().accept(new DeclaratorVisitor(environment)),
                ctx.abstractDeclarator().accept(new AbstractDeclaratorVisitor(environment))
        );
    }
}
