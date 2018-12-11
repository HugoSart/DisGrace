package com.hugovs.jps.structure.semanthic;

import java.util.List;

public class Util {

    public static void updateVariableTypes(List<Variable> vars, Type type) {
        for (Variable var : vars)
            var.setType(type);
    }

    public static String arrayToString(Object[] obj) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < obj.length; i++) {
            builder.append(obj[i].toString());
            if (i < obj.length - 1) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    public static String spaces(int i) {
        StringBuilder b = new StringBuilder();
        for (int a = 0; a < i; a++)
            b.append(' ');
        return b.toString();
    }

}
