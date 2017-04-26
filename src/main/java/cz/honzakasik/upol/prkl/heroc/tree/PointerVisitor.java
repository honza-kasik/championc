package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Pointer;

public class PointerVisitor extends HerocBaseVisitor<Pointer> {

    private final Environment environment;

    public PointerVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Pointer visitPointer(HerocParser.PointerContext ctx) {
        return new Pointer(ctx.getChildCount());
    }
}
