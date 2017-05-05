package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Node;
import cz.honzakasik.upol.prkl.heroc.model.Pointer;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.Optional;

/**
 * Declaration of a variable
 */
public class VariableDeclaration extends Node {

    private Optional<Pointer> pointer;
    private String name;

    public VariableDeclaration(String name) {
        this.pointer = Optional.empty();
        this.name = name;
    }

    public VariableDeclaration(String name, Pointer pointer) {
        this(name);
        this.pointer = Optional.of(pointer);
    }

    public String getName() {
        return name;
    }

    public Optional<Pointer> getPointer() {
        return pointer;
    }

    @Override
    public void appendStringRepresentationToBuilder(OutputBuilder outputBuilder, int depth) {
        outputBuilder.append(this.getClass().getSimpleName() + ":" +
                        "{" +
                        "isPointer:" + (pointer.isPresent() ? "true" : "false") + "," +
                        "name: " + name +
                        "}",
                depth
        );
    }
}
