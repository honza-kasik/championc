package cz.honzakasik.upol.prkl.heroc.model.declarator;

import cz.honzakasik.upol.prkl.heroc.model.Pointer;

/**
 * Declaration af an array variable
 */
public class ArrayDeclaration extends VariableDeclaration {

    private final long arrayDimension;

    public ArrayDeclaration(String name, long arrayDimension) {
        super(name);
        this.arrayDimension = arrayDimension;
    }

    public ArrayDeclaration(String name, long arrayDimension, Pointer pointer) {
        super(name, pointer);
        this.arrayDimension = arrayDimension;
    }

    public long getArrayDimension() {
        return arrayDimension;
    }
}
