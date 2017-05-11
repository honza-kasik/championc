package cz.honzakasik.upol.prkl.heroc.tree.declarator;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.ArrayDeclaration;
import cz.honzakasik.upol.prkl.heroc.model.declarator.VariableDeclaration;
import cz.honzakasik.upol.prkl.heroc.tree.PointerVisitor;

public class DirectDeclaratorVisitor extends HerocBaseVisitor<VariableDeclaration> {

    private Environment environment;

    public DirectDeclaratorVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public VariableDeclaration visitSimpleVariableDeclaration(HerocParser.SimpleVariableDeclarationContext ctx) {
        if (ctx.pointer() != null) {
            return new VariableDeclaration(ctx.ID().getText(), ctx.pointer().accept(new PointerVisitor(environment)));
        } else {
            return new VariableDeclaration(ctx.ID().getText());
        }
    }

    @Override
    public VariableDeclaration visitArrayDeclaration(HerocParser.ArrayDeclarationContext ctx) {
        final long arrayDimension = ctx.children.stream()
                .filter(parseTree -> parseTree.getText().equals("["))
                .count();

        if (ctx.pointer() != null) {
            return new ArrayDeclaration(ctx.ID().getText(), arrayDimension, ctx.pointer().accept(new PointerVisitor(environment)));
        } else {
            return new ArrayDeclaration(ctx.ID().getText(), arrayDimension);
        }
    }
}
