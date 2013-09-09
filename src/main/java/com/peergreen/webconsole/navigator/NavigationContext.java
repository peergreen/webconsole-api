package com.peergreen.webconsole.navigator;

import java.util.Map;

/**
 * Navigation context
 *
 * @author Mohammed Boukada
 */
public interface NavigationContext {

    /**
     * Get current path
     *
     * @return current path
     */
    String getPath();

    /**
     * Set path
     *
     * @param path path
     */
    void setPath(String path);

    /**
     * Get navigation properties
     *
     * @return navigation properties
     */
    Map<String, Object> getProperties();
}
