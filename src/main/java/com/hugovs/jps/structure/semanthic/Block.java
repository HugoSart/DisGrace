package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.DuplicatedIdentifierException;
import com.hugovs.jps.structure.exception.UndeclaredIdentifierException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Block {

    private Block parent = null;
    private Map<String, Identifier> identifiers = new HashMap<>();

    public Block() {

    }

    public Block(Block parent) {
        this.parent = parent;
    }

    public void addAll(List<? extends Identifier> ids) {
        for (Identifier id : ids)
            addIdentifier(id);
    }

    public void addIdentifier(Identifier id) {
        if (hasIdentifierInParent(id))
            throw new DuplicatedIdentifierException(id.getId() + " - in identifier declaration");
        identifiers.put(id.getId(), id);
    }

    public Identifier getIdentifier(String id) {
        Identifier i = identifiers.get(id);
        if (i != null)
            return i;
        else if (parent != null)
            return parent.getIdentifier(id);
        throw new UndeclaredIdentifierException();
    }

    public Map<String, Identifier> getIdentifiers() {
        return identifiers;
    }

    public boolean hasIdentifier(String id) {
        return identifiers.get(id) != null;
    }

    private boolean hasIdentifierInParent(Identifier id) {
        if (identifiers.get(id.getId()) != null)
            return true;
        if (parent != null)
            return parent.hasIdentifierInParent(id);
        return false;
    }

    public Block getParent() {
        return parent;
    }

    public void setParent(Block parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (Identifier value : identifiers.values()) {
            builder.append(value.toString());
            if (count < identifiers.size() - 1)
                builder.append(", ");
            count++;
        }
        return getClass().getSimpleName() + "<identifiers=[" + builder.toString() + "]>";
    }
}
