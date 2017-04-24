package cz.honzakasik.upol.prkl.heroc.model;

import java.util.List;

public class FunctionDefinition {

    private List<Declaration> arguments;
    private String name;

    public FunctionDefinition(List<Declaration> arguments, String name) {
        this.arguments = arguments;
        this.name = name;
    }

    public List<Declaration> getArguments() {
        return arguments;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionDefinition that = (FunctionDefinition) o;

        if (arguments != null ? !arguments.equals(that.arguments) : that.arguments != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = arguments != null ? arguments.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
