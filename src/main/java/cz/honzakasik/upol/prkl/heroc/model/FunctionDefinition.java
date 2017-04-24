package cz.honzakasik.upol.prkl.heroc.model;

import java.util.List;

public class FunctionDefinition {

    private List<Declaration> arguments;
    private Declaration returnType;
    private String name;

    public FunctionDefinition(List<Declaration> arguments, Declaration returnType, String name) {
        this.arguments = arguments;
        this.returnType = returnType;
        this.name = name;
    }

    public List<Declaration> getArguments() {
        return arguments;
    }

    public Declaration getReturnType() {
        return returnType;
    }

    public String getName() {
        return name;
    }
}
