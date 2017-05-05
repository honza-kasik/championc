package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.InitDeclarator;
import cz.honzakasik.upol.prkl.heroc.tree.InitializerVisitor;
import cz.honzakasik.upol.prkl.heroc.tree.TypeSpecifierVisitor;

public class InitDeclaratorVisitor extends HerocBaseVisitor<InitDeclarator> {

    private final Environment environment;

    public InitDeclaratorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public InitDeclarator visitInitDeclarator(HerocParser.InitDeclaratorContext ctx) {
        return new InitDeclarator(
                ctx.accept(new DeclaratorVisitor(environment)),
                ctx.accept(new TypeSpecifierVisitor(environment)),
                ctx.accept(new InitializerVisitor(environment))
        );
    }
}