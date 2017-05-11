package cz.honzakasik.upol.prkl.heroc.model;

import cz.honzakasik.upol.prkl.heroc.model.expression.Expression;
import cz.honzakasik.upol.prkl.heroc.printer.OutputBuilder;

import java.util.Optional;

public class VariableReference extends Node implements Expression {

    private final String name;
    private final Optional<Pointer> pointer;

    public VariableReference(String name) {
        this.name = name;
        this.pointer = Optional.empty();
    }

    public VariableReference(String name, Pointer pointer) {
        this.name = name;
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
        outputBuilder.append(VariableReference.class.getSimpleName() + " {name: " + name +
                ", isPointer: " + pointer.isPresent() + "}", depth);
    }
}
