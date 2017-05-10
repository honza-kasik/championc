package cz.honzakasik.upol.prkl.heroc.tree;

import com.sun.org.apache.xpath.internal.operations.Variable;
import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.declarator.VariableDeclaration;
import cz.honzakasik.upol.prkl.heroc.model.function.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.management.counter.Variability;

import java.util.List;
import java.util.stream.Collectors;

public class FucntionArgumentListVisitor extends HerocBaseVisitor<List<VariableDeclaration>> {

    private static final Logger log = LoggerFactory.getLogger(FucntionArgumentListVisitor.class);

    private Environment environment;

    public FucntionArgumentListVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public List<VariableDeclaration> visitFunctionArgumentList(HerocParser.FunctionArgumentListContext ctx) {
        return ctx.ID().stream()
                .map(terminalNode -> new VariableDeclaration(terminalNode.toString()))
                .peek(parameter -> log.debug("Visited {} function argument", parameter))
                .collect(Collectors.toList());
    }
}
