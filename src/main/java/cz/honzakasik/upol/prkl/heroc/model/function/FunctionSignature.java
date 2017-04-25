package cz.honzakasik.upol.prkl.heroc.model.function;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionSignature {

    private String name;
    private List<Parameter> parameters;

    public FunctionSignature(String name, List<Parameter> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        return name + '(' + parameters.stream().map(Parameter::getName).collect(Collectors.joining(",")) + ')';
    }
}
