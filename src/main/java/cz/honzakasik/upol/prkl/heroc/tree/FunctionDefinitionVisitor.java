package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.model.FunctionDefinition;

//TODO
public class FunctionDefinitionVisitor extends HerocBaseVisitor<FunctionDefinition> {

    @Override
    public FunctionDefinition visitFunctionDefinition(HerocParser.FunctionDefinitionContext ctx) {
        return super.visitFunctionDefinition(ctx);
    }
}
