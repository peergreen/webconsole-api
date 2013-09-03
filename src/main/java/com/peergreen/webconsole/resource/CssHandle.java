package com.peergreen.webconsole.resource;

/**
 * Css contribution handle
 * @author Mohammed Boukada
 */
public interface CssHandle {
    /**
     * Get css content
     * @return css content
     */
    String get();

    /**
     * Update css content
     * @param cssContent new css content
     */
    void update(String cssContent);

    /**
     * Remove css contribution
     */
    void remove();
}
