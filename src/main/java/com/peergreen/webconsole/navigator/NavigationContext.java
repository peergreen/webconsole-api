package com.peergreen.webconsole.navigator;

import java.util.Map;

/**
 * Navigation context
 * @author Mohammed Boukada
 */
public interface NavigationContext {
    String getPath();
    void setPath(String path);
    Map<String, Object> getProperties();
}
