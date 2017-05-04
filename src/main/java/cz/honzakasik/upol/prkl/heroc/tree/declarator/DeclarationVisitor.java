package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.Declaration;

import java.util.stream.Collectors;

public class DeclarationVisitor extends HerocBaseVisitor<Declaration> {

    private Environment environment;

    /**
     * Creates new instance
     */
    public DeclarationVisitor(Environment parentEnvironment) {
        this.environment = parentEnvironment;
    }

    @Override
    public Declaration visitDeclaration(HerocParser.DeclarationContext ctx) {
        return new Declaration(ctx.initDeclarator().stream().map(
                initDeclaratorContext -> initDeclaratorContext.accept(new InitDeclaratorVisitor(environment))
        ).collect(Collectors.toList()));
    }
}
