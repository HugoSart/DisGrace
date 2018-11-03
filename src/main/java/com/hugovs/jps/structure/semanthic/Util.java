package com.hugovs.jps.structure.semanthic;

import java.util.List;

public class Util {

    public static void updateVariableTypes(List<Variable> vars, Type type) {
        for (Variable var : vars)
            var.setType(type);
    }

}
