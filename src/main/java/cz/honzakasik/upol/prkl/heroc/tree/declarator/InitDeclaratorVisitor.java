package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Initializer;
import cz.honzakasik.upol.prkl.heroc.model.declarator.InitDeclarator;

public class InitDeclaratorVisitor extends HerocBaseVisitor<InitDeclarator> {

    private final Environment environment;

    public InitDeclaratorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public InitDeclarator visitInitDeclarator(HerocParser.InitDeclaratorContext ctx) {
        Initializer initializer = null;

        if (ctx.initializer() != null) {
            initializer = ctx.initializer().accept(new InitializerVisitor(environment));
        }

        return new InitDeclarator(
                ctx.directDeclarator().accept(new DirectDeclaratorVisitor(environment)),
                //TODO add variable declaration to environment
                initializer
        );
    }
}
