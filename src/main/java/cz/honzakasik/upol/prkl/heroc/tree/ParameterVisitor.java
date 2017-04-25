package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.function.Parameter;

public class ParameterVisitor extends HerocBaseVisitor<Parameter> {

    private Environment environment;

    public ParameterVisitor(Environment environment) {
        this.environment = environment;
    }
}
