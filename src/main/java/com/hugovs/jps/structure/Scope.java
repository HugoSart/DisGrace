package com.hugovs.jps.structure;

import com.hugovs.jps.structure.exception.DuplicatedIdentifierException;
import com.hugovs.jps.structure.exception.UndeclaredIdentifierException;

import java.util.List;

/**
 * User: hugo_<br/>
 * Date: 11/10/2018<br/>
 * Time: 16:53<br/>
 */
public class Scope {

    private List<Identifier> identifiers;

    public void addIdentifier(Identifier id) {
        if (identifiers.contains(id)) throw new DuplicatedIdentifierException();
        identifiers.add(id);
    }

    public boolean hasIdentifier(Identifier id) {
        return identifiers.contains(id);
    }

    public boolean hasIdentifier(String name) {
        for (Identifier identifier : identifiers)
            if (identifier.name.equals(name)) return true;
        return false;
    }

    public Identifier getIdentifier(String name) {
        for (Identifier identifier : identifiers)
            if (identifier.name.equals(name)) return identifier;
        throw new UndeclaredIdentifierException();
    }

}
