package cz.honzakasik.upol.prkl.heroc.environment;

import cz.honzakasik.upol.prkl.heroc.model.function.FunctionDefinition;

import java.util.LinkedList;
import java.util.List;

public class Environment {

    private final Environment parentEnvironment;
    private final List<FunctionDefinition> functionDefinitions;

    public Environment(Environment parentEnvironment, List<FunctionDefinition> functionDefinitions) {
        this.parentEnvironment = parentEnvironment;
        this.functionDefinitions = functionDefinitions;
    }

    public Environment(Environment parentEnvironment) {
        this(parentEnvironment, new LinkedList<>());
    }

    public Environment() {
        this(null);
    }

    public Environment getParentEnvironment() {
        return parentEnvironment;
    }

    public List<FunctionDefinition> getFunctionDefinitions() {
        return functionDefinitions;
    }

    public void addFunctionDefinition(FunctionDefinition functionDefinition) {
        checkIfFunctionIsAlreadyDefinedInHierarchy(functionDefinition);
        functionDefinitions.add(functionDefinition);
    }

    public boolean isGlobalEnvironment() {
        return parentEnvironment == null;
    }

    //TODO write unit tests
    /**
     * Goes up to the global environment and checks whether there is a function with same signature
     * @param definition
     * @return true if it is defined somewhere in hierarchy, false itherwise
     */
    public boolean isFunctionDefinitionAlreadyDefinedInHierarchy(FunctionDefinition definition) {
        Environment environment = this;
        while (!environment.isGlobalEnvironment()) {
            if (environment.getFunctionDefinitions().contains(definition)) {
                return true;
            }
            environment = environment.getParentEnvironment();
        }
        if (environment.getFunctionDefinitions().contains(definition)) {
            return true;
        }
        return false;
    }

    private void checkIfFunctionIsAlreadyDefinedInHierarchy(FunctionDefinition definition) throws FunctionAlreadyDefinedException {
        if (isFunctionDefinitionAlreadyDefinedInHierarchy(definition)) {
            throw new FunctionAlreadyDefinedException();
        }
    }
}
