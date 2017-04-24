package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.model.Declaration;

//TODO Environment as parameter
//TODO Parse data into environment
public class DeclarationVisitor extends HerocBaseVisitor<Declaration> {

    @Override
    public Declaration visitDeclaration(HerocParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }
}
