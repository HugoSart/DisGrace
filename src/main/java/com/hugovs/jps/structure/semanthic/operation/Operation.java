package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.structure.exception.IncompatibleTypeException;
import com.hugovs.jps.structure.semanthic.Type;
import com.hugovs.jps.structure.semanthic.Value;

public abstract class Operation extends Value {

    private Value firstOperand, secondOperand;

    private Type firstOperandType, secondOperandType;

    public Operation(Type firstOperandType, Type secondOperandType, Type type) {
        setType(type);
        this.firstOperandType = firstOperandType;
        this.secondOperandType = secondOperandType;
    }

    public Value getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Value firstOperand) {
        if (firstOperand.getType() != this.firstOperandType)
            throw new IncompatibleTypeException(this.firstOperandType, firstOperand.getType());
        this.firstOperand = firstOperand;
    }

    public Value getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Value secondOperand) {
        if (secondOperand.getType() != this.secondOperandType)
            throw new IncompatibleTypeException(this.secondOperandType, secondOperand.getType());
        this.secondOperand = secondOperand;
    }

    public Type getFirstOperandType() {
        return firstOperandType;
    }

    private void setFirstOperandType(Type firstOperandType) {
        this.firstOperandType = firstOperandType;
    }

    public Type getSecondOperandType() {
        return secondOperandType;
    }

    private void setSecondOperandType(Type secondOperandType) {
        this.secondOperandType = secondOperandType;
    }

    public void setOperands(Value o1, Value o2) {
        setFirstOperand(o1);
        setSecondOperand(o2);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<firstOperand=" + firstOperand + ", secondOperand=" + secondOperand + ", type=" + getType() + ">";
    }
}
