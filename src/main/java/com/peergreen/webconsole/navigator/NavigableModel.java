package com.peergreen.webconsole.navigator;

import java.lang.reflect.Method;

/**
 * @author Mohammed Boukada
 */
public class NavigableModel {

    private NavigableModel parent;
    private String alias;
    private Object object;
    private Method callbackMethod;

    public NavigableModel(NavigableModel parent, String alias, Object object, Method method) {
        this.parent = parent;
        this.alias = alias;
        this.object = object;
        this.callbackMethod = method;

    }

    public Object getObject() {
        return object;
    }

    public Method getCallbackMethod() {
        return callbackMethod;
    }

    public String getFullPath() {
        if (parent != null) return parent.getFullPath() + alias;
        else return alias;
    }
}
