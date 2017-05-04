package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.Declarator;
import cz.honzakasik.upol.prkl.heroc.tree.PointerVisitor;

public class DeclaratorVisitor extends HerocBaseVisitor<Declarator> {

    private Environment environment;

    public DeclaratorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Declarator visitDeclarator(HerocParser.DeclaratorContext ctx) {
        return new Declarator(
                ctx.pointer().accept(new PointerVisitor(environment)),
                ctx.directDeclarator().accept(new DirectDeclaratorVisitor(environment))
        );
    }
}
