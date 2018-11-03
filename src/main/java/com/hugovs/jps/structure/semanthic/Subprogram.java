package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.DuplicatedIdentifierException;

import java.util.ArrayList;
import java.util.List;

public class Subprogram extends Identifier {

    private List<Variable> parameters = new ArrayList<>();
    private Type returnType = Type.VOID;
    private Block block = null;

    public List<Variable> getParameters() {
        return parameters;
    }

    public void setParameters(List<Variable> parameters) {
        this.parameters = parameters;
        block.addAll(parameters);
    }

    public void addParameter(Variable parameter) {
        for (Variable variable : parameters)
            if (variable.getId().equals(parameter.getId()))
                throw new DuplicatedIdentifierException(parameter.getId() + " - in parameter declaration");
        this.parameters.add(parameter);
        block.addIdentifier(parameter);
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        for (Variable parameter : parameters)
            if (block.getIdentifier(parameter.getId()) != null)
                throw new DuplicatedIdentifierException(parameter.getId() + " - in block manipulation");

        this.block = block;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(), b2 = new StringBuilder();

        int count = 0;
        for (Variable parameter : parameters) {
            builder.append(parameter);
            if (count < parameters.size() - 1) builder.append(", ");
            count++;
        }

        return getClass().getSimpleName() + "<id=" + getId() + ", returnType: " + returnType + ", " +
                "parameters=[" + builder.toString() + "], " +
                "block=" + block + ">";
    }
}
