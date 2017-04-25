package cz.honzakasik.upol.prkl.heroc.model.function;

import cz.honzakasik.upol.prkl.heroc.model.Variable;

public class Parameter implements Variable {

    private String name;

    public Parameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
