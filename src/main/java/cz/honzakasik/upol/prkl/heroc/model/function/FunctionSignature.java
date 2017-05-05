package cz.honzakasik.upol.prkl.heroc.model.function;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionSignature extends Node {

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
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("name: '" + name + "'", depth + 1);
        parameters.forEach(parameter -> parameter.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
    }
}
