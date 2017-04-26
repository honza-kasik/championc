package cz.honzakasik.upol.prkl.heroc.tree;

import cz.honzakasik.upol.prkl.heroc.HerocBaseVisitor;
import cz.honzakasik.upol.prkl.heroc.HerocParser;
import cz.honzakasik.upol.prkl.heroc.environment.Environment;
import cz.honzakasik.upol.prkl.heroc.model.Initializer;

import java.util.stream.Collectors;

public class InitializerVisitor extends HerocBaseVisitor<Initializer> {

    private Environment environment;

    public InitializerVisitor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Initializer visitInitializer(HerocParser.InitializerContext ctx) {
        return new Initializer(
                ctx.expression().accept(new ExpressionVisitor(environment)),
                ctx.initializer().stream()
                        .map(initializerContext -> initializerContext.accept(new InitializerVisitor(environment)))
                        .collect(Collectors.toList())
        );
    }
}
