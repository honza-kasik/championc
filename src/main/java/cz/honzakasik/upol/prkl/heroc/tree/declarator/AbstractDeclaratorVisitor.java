package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.AbstractDeclarator;
import cz.honzakasik.upol.prkl.heroc.tree.PointerVisitor;

public class AbstractDeclaratorVisitor extends HerocBaseVisitor<AbstractDeclarator> {

    private final Environment environment;

    public AbstractDeclaratorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public AbstractDeclarator visitAbstractDeclarator(HerocParser.AbstractDeclaratorContext ctx) {
        return new AbstractDeclarator(
                ctx.pointer().accept(new PointerVisitor(environment)),
                ctx.directAbstractDeclarator().accept(new DirectAbstractDeclaratorVisitor(environment))
        );
    }

}
