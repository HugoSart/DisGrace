package com.hugovs.jps.structure.data;

import java.util.List;

/**
 * User: hugo_<br/>
 * Date: 11/10/2018<br/>
 * Time: 16:37<br/>
 */
public class Vector<T extends List> implements Reference<T> {

    private T data;

    @Override
    public T getValue() {
        return data;
    }

}
