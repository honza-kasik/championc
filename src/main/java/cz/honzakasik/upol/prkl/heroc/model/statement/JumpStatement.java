package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;

import java.util.Optional;

public class JumpStatement extends Node implements Statement {

    public enum Type {
        RETURN("return"),
        CONTINUE("continue"),
        BREAK("break");

        private String keyword;

        Type(String keyword) {
            this.keyword = keyword;
        }

        public String getKeyword() {
            return keyword;
        }
    }

    private Type type;
    private Optional<Expression> returnExpression;

    public JumpStatement(Type type) {
        this.type = type;
    }

    public JumpStatement(Type type, Expression returnExpression) {
        this.type = type;
        this.returnExpression = Optional.of(returnExpression);
    }

    public Type getType() {
        return type;
    }

    public Optional<Expression> getReturnExpression() {
        return returnExpression;
    }
}
