package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionSignature;

public class SignatureVisitor extends HerocBaseVisitor<FunctionSignature> {

    private Environment environment;

    public SignatureVisitor(Environment environment) {
        this.environment = environment;
    }
}
