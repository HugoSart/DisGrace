package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.InvalidArraySizeException;

public class Variable extends Identifier {

    private Type type = Type.VOID;
    private boolean isArray = false;
    private int length = 1;
    private boolean isInitialized = false;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public void setInitialized(boolean initialized) {
        isInitialized = initialized;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
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
        return getClass().getSimpleName() + "<id=" + getId() + ", type=" + type + ", isInitialized=" + isInitialized + ", isArray=" + isArray + ", length=" + length + ">";
    }
}
