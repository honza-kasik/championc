package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

public class VariableReference extends Node implements Expression {

    private String name;

    public VariableReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
