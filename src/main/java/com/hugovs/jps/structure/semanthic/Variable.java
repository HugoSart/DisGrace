package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.IncompatibleTypeException;
import com.hugovs.jps.structure.exception.InvalidArraySizeException;

import java.util.ArrayList;
import java.util.List;

public class Variable extends Identifier {

    private Type type = Type.VOID;
    private boolean parameter = false;
    private boolean isArray = false;
    private int length = 1;
    private Value value = null;
    private List<Value> values = new ArrayList<>();

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        //if (value != null && value.getType() != type) throw new IncompatibleTypeException(type, value.getType());
        if (values != null)
            for (Value value : values)
                if (value != null && value.getType() != type)
                    throw new IncompatibleTypeException(type, value.getType());
        this.type = type;
    }

    public boolean isInitialized() {
        return value != null;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void addValue(Value value) {
        values.add(value);
    }

    public Value getValue(int i) {
        return values.get(i);
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public Value getValue() {
        return value;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
    }

    public boolean isParameter() {
        return parameter;
    }

    public void setParameter(boolean parameter) {
        this.parameter = parameter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length <= 0)
            throw new InvalidArraySizeException(length);
        this.length = length;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<id=" + getId() + ", type=" + type + ", isArray=" + isArray + ", length=" + length + ", value=" + value + ", " +
                "values=" + Util.arrayToString(values.toArray()) + ">";
    }
}
