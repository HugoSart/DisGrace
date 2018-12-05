package com.hugovs.jps.structure.semanthic;

import com.hugovs.jps.structure.exception.DuplicatedIdentifierException;
import com.hugovs.jps.structure.exception.UndeclaredIdentifierException;
import com.hugovs.jps.structure.semanthic.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Block {

    private Block parent = null;
    private Map<String, Identifier> identifiers = new HashMap<>();
    private List<Command> commands = new ArrayList<>();

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
        if (hasIdentifier(id.getId()))
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

    public void addCommand(Command cmd) {
        commands.add(cmd);
    }

    public List<Command> getCommands() {
        return commands;
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

    public void print(int s) {
        String spaces = spaces(s);
        System.out.println(spaces + "Block:");
        System.out.println(spaces + "  Identifiers: ");
        for (Identifier value : identifiers.values()) {
            System.out.println(spaces + "    " + value.toString());
            if (value instanceof Subprogram)
                ((Subprogram) value).getBlock().print(s + 6);
        }
        System.out.println(spaces + "  Commands:");
        for (Command command : commands)
            System.out.println(spaces + "    " + command.toString());
    }

    public void print() {
        print(0);
    }

    private String spaces(int s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s; i++)
            builder.append(" ");
        return builder.toString();
    }

}
