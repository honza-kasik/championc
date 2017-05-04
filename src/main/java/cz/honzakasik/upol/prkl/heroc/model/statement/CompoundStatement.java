package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.declarator.Declaration;

import java.util.List;

/**
 * Block statement with its own environment
 */
public class CompoundStatement implements Statement {

    private List<Declaration> declarations;
    private List<Statement> statements;

    public CompoundStatement(List<Declaration> declarations, List<Statement> statements) {
        this.declarations = declarations;
        this.statements = statements;
    }

    public List<Declaration> getDeclarations() {
        return declarations;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
