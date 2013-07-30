package com.peergreen.webconsole.navigator;

import java.util.Map;

/**
 * @author Mohammed Boukada
 */
public interface NavigableContext {
    String getPath();
    void setPath(String path);
    Map<String, Object> getProperties();
}
