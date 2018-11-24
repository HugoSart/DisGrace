package com.hugovs.jps.structure.semanthic.operation;

import com.hugovs.jps.Token;
import com.hugovs.jps.structure.exception.IncompatibleTypeException;
import com.hugovs.jps.structure.semanthic.Type;
import com.hugovs.jps.structure.semanthic.Value;
import com.hugovs.jps.structure.semanthic.Variable;
import com.hugovs.jps.structure.semanthic.operation.bool.AndOperation;
import com.hugovs.jps.structure.semanthic.operation.bool.NotOperation;
import com.hugovs.jps.structure.semanthic.operation.bool.OrOperation;
import com.hugovs.jps.structure.semanthic.operation.compare.*;
import com.hugovs.jps.structure.semanthic.operation.integer.*;
import com.hugovs.jps.structure.semanthic.operation.string.ConcatOperation;

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

    public static Operation getForToken(Token tokenOp, Token tokenCop, Token tokenBop, Variable v1) {
        Operation op = null;
        if (tokenOp != null) {
            String strOp = tokenOp.toString();
            switch(strOp) {
                case "+":
                    if (v1.getType() == Type.STRING) op = new ConcatOperation();
                    else op = new SumOperation(); break;
                case "-": op = new MinusOperation(); break;
                case "*": op = new TimesOperation(); break;
                case "/": op = new DivideOperation(); break;
                case "%": op = new ModOperation(); break;
            }
        } else if (tokenCop != null) {
            String strOp = tokenCop.toString();
            switch(strOp) {
                case ">": op = new GreaterOperation(); break;
                case "<": op = new SmallerOperation(); break;
                case ">=": op = new GreaterEqualsOperation(); break;
                case "<=": op = new SmallerEqualsOperation(); break;
                case "==": op = new EqualsOperation(); break;
                case "!=": op = new DifferentOperation(); break;
            }
        } else if (tokenBop != null) {
            String strOp = tokenBop.toString();
            switch(strOp) {
                case "&&": op = new AndOperation(); break;
                case "||": op = new OrOperation(); break;
                case "!": op = new NotOperation(); break;
            }
        }
        return op;
    }

    public static Operation getForToken(Token tokenOp, Token tokenCop, Token tokenBop, Value v1) {
        Operation op = null;
        if (tokenOp != null) {
            String strOp = tokenOp.toString();
            switch(strOp) {
                case "+":
                    if (v1.getType() == Type.STRING) op = new ConcatOperation();
                    else op = new SumOperation(); break;
                case "-": op = new MinusOperation(); break;
                case "*": op = new TimesOperation(); break;
                case "/": op = new DivideOperation(); break;
                case "%": op = new ModOperation(); break;
            }
        } else if (tokenCop != null) {
            String strOp = tokenCop.toString();
            switch(strOp) {
                case ">": op = new GreaterOperation(); break;
                case "<": op = new SmallerOperation(); break;
                case ">=": op = new GreaterEqualsOperation(); break;
                case "<=": op = new SmallerEqualsOperation(); break;
                case "==": op = new EqualsOperation(); break;
                case "!=": op = new DifferentOperation(); break;
            }
        } else if (tokenBop != null) {
            String strOp = tokenBop.toString();
            switch(strOp) {
                case "&&": op = new AndOperation(); break;
                case "||": op = new OrOperation(); break;
                case "!": op = new NotOperation(); break;
            }
        }
        return op;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<firstOperand=" + firstOperand + ", secondOperand=" + secondOperand + ", type=" + getType() + ">";
    }
}
