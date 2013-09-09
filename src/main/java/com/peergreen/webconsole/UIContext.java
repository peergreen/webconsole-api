package com.peergreen.webconsole;

import com.peergreen.webconsole.navigator.ViewNavigator;
import com.vaadin.ui.UI;

/**
 * UI context
 *
 * @author Mohammed Boukada
 */
public interface UIContext {

    /**
     * Get Web Console security manager
     *
     * @return security manager
     */
    ISecurityManager getSecurityManager();

    /**
     * Get Vaadin UI
     *
     * @return Vaadin UI
     */
    UI getUI();

    /**
     * Get Vaadin view navigator
     *
     * @return view navigator
     */
    ViewNavigator getViewNavigator();

    /**
     * Get UI id
     *
     * @return UI id
     */
    String getUIId();
}
