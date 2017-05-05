package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;

public class FunctionCallStatement extends Node implements Statement {

    private String functionName;
    private List<Expression> arguments;

    public FunctionCallStatement(String functionName, List<Expression> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass().getSimpleName(), depth)
                .append("functionName: '" + functionName + "'", depth + 1)
                .append("arguments: ", depth + 1);
        if (arguments.size() == 0) {
            outputBuilder.append("there are no arguments!", depth + 2);
        } else {
            //outputBuilder.append(String.valueOf(arguments.get(0)), depth + 2);
            arguments.forEach(expression -> expression.appendStringRepresentationToBuilder(outputBuilder, depth + 2));
        }
    }
}
