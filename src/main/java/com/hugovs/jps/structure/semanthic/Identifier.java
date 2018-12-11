package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.llvm.LlvmRepresentable;

public abstract class Identifier extends Value implements LlvmRepresentable {

    private String id = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Identifier)) return false;
        return id.equals(((Identifier) obj).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<id=" + id + ">";
    }

}
