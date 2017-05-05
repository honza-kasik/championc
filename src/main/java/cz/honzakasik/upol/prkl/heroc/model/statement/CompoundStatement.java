package cz.honzakasik.upol.prkl.heroc.model.statement;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.declarator.Declaration;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.List;

/**
 * Block statement with its own environment
 */
public class CompoundStatement extends Node implements Statement {

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

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass(), depth)
                .append("declarations:", depth);
        declarations.forEach(declaration -> declaration.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
        outputBuilder.append("statements:", depth);
        statements.forEach(statement -> statement.appendStringRepresentationToBuilder(outputBuilder, depth + 1));
    }
}
