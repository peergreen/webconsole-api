package com.peergreen.webconsole.resource;

/**
 * @author Mohammed Boukada
 */
public interface CssHandle {
    String get();
    void update(String cssContent);
    void remove();
}
