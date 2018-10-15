package com.hugovs.jps.structure.data;

/**
 * User: hugo_<br/>
 * Date: 11/10/2018<br/>
 * Time: 16:32<br/>
 */
public class Data<T> implements Reference<T> {

    private T data;

    @Override
    public T getValue() {
        return data;
    }

}
