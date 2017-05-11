package cz.honzakasik.upol.prkl.heroc.model;

public class Pointer extends Node {

    private final int count;

    public Pointer(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
