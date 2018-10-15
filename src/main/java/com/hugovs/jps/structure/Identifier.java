package com.hugovs.jps.structure;

import com.hugovs.jps.structure.data.Reference;

/**
 * User: hugo_<br/>
 * Date: 11/10/2018<br/>
 * Time: 16:33<br/>
 */
public class Identifier<T> {

    public String name;
    public Reference<T> data;

    @Override
    public boolean equals(Object obj) {
        return name.equals(obj);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
