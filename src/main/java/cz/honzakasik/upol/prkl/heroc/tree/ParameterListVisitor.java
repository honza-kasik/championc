package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.function.FunctionSignature;
import cz.honzakasik.upol.prkl.heroc.model.function.Parameter;

import java.util.List;
import java.util.stream.Collectors;

public class ParameterListVisitor extends HerocBaseVisitor<List<Parameter >> {

    private Environment environment;

    public ParameterListVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public List<Parameter> visitFunctionArgumentList(HerocParser.FunctionArgumentListContext ctx) {
        return ctx.ID().stream()
                .map(terminalNode -> terminalNode.accept(new ParameterVisitor(environment)))
                .collect(Collectors.toList());
    }
}
