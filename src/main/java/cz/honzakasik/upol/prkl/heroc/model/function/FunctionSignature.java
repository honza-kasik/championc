package cz.honzakasik.upol.prkl.heroc.model.function;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.declarator.VariableDeclaration;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionSignature extends Node {

    private static final Logger log = LoggerFactory.getLogger(FunctionSignature.class);

    private String name;
    private List<VariableDeclaration> parameters;

    public FunctionSignature(String name, List<VariableDeclaration> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public List<VariableDeclaration> getParameters() {
        return parameters;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("name: '" + name + "'", depth + 1);
        log.info(parameters.toString());
        parameters.forEach(parameter -> parameter.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
    }
}
