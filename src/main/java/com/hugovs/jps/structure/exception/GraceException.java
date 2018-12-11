package com.hugovs.jps.structure.exception;

import com.hugovs.jps.Lexer;

public class GraceException extends RuntimeException {

    public GraceException(String msg) {
        super(msg + ". Near line " + Lexer.lineCount);
    }

}
