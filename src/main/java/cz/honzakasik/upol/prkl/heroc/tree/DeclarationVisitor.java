package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Declaration;

public class DeclarationVisitor extends HerocBaseVisitor<Declaration> {

    private Environment environment;

    /**
     * Creates new instance
     * @param parentEnvironment lexically superior environment
     */
    public DeclarationVisitor(Environment parentEnvironment) {
        this.environment = new Environment(parentEnvironment);
    }

    //TODO Parse data into environment
    @Override
    public Declaration visitDeclaration(HerocParser.DeclarationContext ctx) {
        ctx.initDeclaratorList().initDeclarator().get(0).initializer().assignmentExpression().
        return super.visitDeclaration(ctx);
    }
}
